package com.ErasmusProject.recommendation;
/**
 * @author Nina
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.ErasmusProject.model.DegreeProgramme;
import com.ErasmusProject.rest.EctsStore;
import com.ErasmusProject.rest.StudentStore;

import opennlp.tools.stemmer.snowball.SnowballStemmer;
import opennlp.tools.stemmer.snowball.SnowballStemmer.ALGORITHM;


public class DegreeProgrammeRecommendation {
	
	private  ArrayList<DegreeProgramme> programmes = new ArrayList<DegreeProgramme>();
	
	public class SimilarityValue{
		private String programme1;
		private String programme2;
		private Double value;
		public String getProgramme1() {
			return programme1;
		}
		public void setProgramme1(String programme1) {
			this.programme1 = programme1;
		}
		public String getProgramme2() {
			return programme2;
		}
		public void setProgramme2(String programme2) {
			this.programme2 = programme2;
		}
		public Double getValue() {
			return value;
		}
		public void setValue(Double value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return "SimilarityValue [programme1=" + programme1 + ", programme2=" + programme2 + ", value=" + value
					+ "]";
		}
	}
	
	public static LinkedHashMap<String, Double> findSimilarProgrammes(String programmeId){
		LinkedHashMap<String, Double> similarProgrammes = new LinkedHashMap<>();
		for(String key:StudentStore.similarityMatrix.keySet()){
			if(StudentStore.similarityMatrix.get(key).getProgramme1().equals(programmeId)){
				similarProgrammes.put(StudentStore.similarityMatrix.get(key).getProgramme2(), StudentStore.similarityMatrix.get(key).getValue());
				System.out.println("programme1 equal");
			}
			else if (StudentStore.similarityMatrix.get(key).getProgramme2().equals(programmeId)){
				similarProgrammes.put(StudentStore.similarityMatrix.get(key).getProgramme1(), StudentStore.similarityMatrix.get(key).getValue());
				System.out.println("programme 2 equal");
			}
		}
		System.out.println(similarProgrammes);
		return similarProgrammes.entrySet().stream()
			    .sorted(Entry.comparingByValue())
			    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
			                              (e1, e2) -> e1, LinkedHashMap::new));
	}

	public  HashMap<String, SimilarityValue> generateSimilarityMatrix(){
		HashMap<String, SimilarityValue> similarityMatrix = new HashMap<>();
		loadProgrammeData();
		HashMap<String, SimilarityValue> titlesMatrix = createTitlesMatrix();
		HashMap<String, SimilarityValue> informationMatrix = createInformationMatrix();
		HashMap<String, SimilarityValue> qualificationMatrix = createQualificationMatrix();
		
		SimilarityValue sv = new SimilarityValue();
		Double value = 0.0;
		for (String key : titlesMatrix.keySet()) {
			sv = new SimilarityValue();
			sv.setProgramme1(key.split(",")[0]);
			sv.setProgramme2(key.split(",")[1]);
			value = titlesMatrix.get(key).getValue() * 15 + qualificationMatrix.get(key).getValue() * 50 + informationMatrix.get(key).getValue() * 35;
			sv.setValue(value);
			similarityMatrix.put(key, sv);
		}
		return similarityMatrix;
	}
	
	public  void loadProgrammeData(){
		EctsStore es = new EctsStore();
		programmes = es.getProgrammes();
		for (DegreeProgramme programme : programmes) {
			programme = toLowerCase(programme);
			programme = stem(programme);
			try {
				programme = removeStopwords(programme);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public DegreeProgramme toLowerCase(DegreeProgramme programme){
		programme.setInformation(programme.getInformation().replaceAll("[^a-zA-Z ]", "").toLowerCase());
		programme.setDegreeProgrammeTitle(programme.getDegreeProgrammeTitle().replaceAll("[^a-zA-Z ]", "").toLowerCase());
		programme.setQualification(programme.getQualification().replaceAll("[^a-zA-Z ]", "").toLowerCase());
		return programme;
	}
	public DegreeProgramme stem(DegreeProgramme programme){
		SnowballStemmer stemmer = new SnowballStemmer(ALGORITHM.ENGLISH);
		
		String data = "";
		for (String  word : programme.getInformation().split("\\s+")) {
			data += stemmer.stem(word) + " ";
		}
		programme.setInformation(data);
		
		data = "";
		for(String word: programme.getDegreeProgrammeTitle().split("\\s+")){
			data += stemmer.stem(word) + " ";
		}
		programme.setDegreeProgrammeTitle(data);
		
		data = "";
		for(String word: programme.getQualification().split("\\s+")){
			data += stemmer.stem(word) + " ";
		}
		programme.setQualification(data);
		
		
		return programme;
	}
	public DegreeProgramme removeStopwords(DegreeProgramme programme) throws FileNotFoundException, IOException{
		String regex = "\\b(";
		try(BufferedReader br = new BufferedReader(new FileReader("D:/predmeti/SW_OTIS/triple-store/src/main/java/com/ErasmusProject/recommendation/stopwords"))){
			String line;
			while((line = br.readLine())!=null){
				regex += line + "|";
			}
		}
		regex = regex.substring(0, regex.length()-1);
		regex += ")\\b\\s?";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(programme.getDegreeProgrammeTitle());
		String s = m.replaceAll("");
		programme.setDegreeProgrammeTitle(s);
		
		m = p.matcher(programme.getQualification());
		s = m.replaceAll("");
		programme.setQualification(s);
		
		m = p.matcher(programme.getInformation());
		s = m.replaceAll("");
		programme.setInformation(s);		
		
		return programme;
	}
	
	public static double cosineSimilarity(Collection<Double> vector1, Collection<Double> vector2) {
		Double[] vectorA = vector1.toArray(new Double[vector1.size()]);
		Double[] vectorB = vector2.toArray(new Double[vector2.size()]);

	
	    double dotProduct = 0.0;
	    double normA = 0.0;
	    double normB = 0.0;
	    for (int i = 0; i < vectorA.length; i++) {
	        dotProduct += vectorA[i] * vectorB[i];
	        normA += Math.pow(vectorA[i], 2);
	        normB += Math.pow(vectorB[i], 2);
	    }   
	    return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
}
	
	
	@SuppressWarnings("unchecked")
	public HashMap<String, SimilarityValue> createTitlesMatrix(){
		int noOfDocsContainingTerm = 0;
		HashMap<String, HashMap<String, Double>> docTermTfidf = new HashMap<>();
		Double TFIDF = 0.0;
		HashMap<String, Double> termTfidf = new HashMap<>();

		for (DegreeProgramme programme : programmes) {
			termTfidf = new HashMap<>();
			for(String term: programme.getDegreeProgrammeTitle().split("\\s+")){
					noOfDocsContainingTerm = calculateNoOfDocsContainingTerm(term, "title");
					TFIDF = calculateTFIDF(programme.getDegreeProgrammeTitle(), term, noOfDocsContainingTerm);
					termTfidf.put(term, TFIDF);
					docTermTfidf.put(programme.getDegreeUnitCode(), termTfidf);
			}
		}
		
		HashMap<String, SimilarityValue> titlesMatrix = new HashMap<>();
		HashMap<String, Double> values1 = new HashMap<>();
		HashMap<String, Double> values2 = new HashMap<>();
		
		
		for (DegreeProgramme programme1: programmes){
			for (DegreeProgramme programme2 : programmes){
				if(!programme1.equals(programme2)){
					values1 = (HashMap<String, Double>) docTermTfidf.get(programme1.getDegreeUnitCode()).clone();
					values2 = (HashMap<String, Double>) docTermTfidf.get(programme2.getDegreeUnitCode()).clone();
					
					//fill in missing data
					if (values2.keySet() != null){
						for(String term : values2.keySet()){
							if(!values1.containsKey(term)){
								values1.put(term, 0.0);
							}
						}
					}
					
					if(values1.keySet() != null){
						for(String term : values1.keySet()){
							if(!values2.containsKey(term)){
								values2.put(term, 0.0);
							}
						}
					}

					Map<String, Double> sortedValues1 = new TreeMap<String, Double>(values1);
					Map<String, Double> sortedValues2 = new TreeMap<String, Double>(values2);
					
					double similarityByTitle = cosineSimilarity(sortedValues1.values(), sortedValues2.values());
					SimilarityValue sv = new SimilarityValue();
					sv.setProgramme1(programme1.getDegreeUnitCode());
					sv.setProgramme2(programme2.getDegreeUnitCode());
					sv.setValue(similarityByTitle);
					if(!titlesMatrix.containsKey(programme1.getDegreeUnitCode() + "," + programme2.getDegreeUnitCode()) && 
					   !titlesMatrix.containsKey(programme2.getDegreeUnitCode() + "," + programme1.getDegreeUnitCode())){
							titlesMatrix.put(programme1.getDegreeUnitCode() + "," + programme2.getDegreeUnitCode(), sv);
					}
				}
			}
		}
		return titlesMatrix;
	}


	@SuppressWarnings("unchecked")
	public HashMap<String, SimilarityValue> createInformationMatrix(){
		int noOfDocsContainingTerm = 0;
		HashMap<String, HashMap<String, Double>> docTermTfidf = new HashMap<>();
		Double TFIDF = 0.0;
		for (DegreeProgramme programme : programmes) {
			HashMap<String, Double> termTfidf = new HashMap<>();
			for(String term: programme.getInformation().split("\\s+")){
					noOfDocsContainingTerm = calculateNoOfDocsContainingTerm(term, "information");
					TFIDF = calculateTFIDF(programme.getInformation(), term, noOfDocsContainingTerm);
					//if(TFIDF > 1.0 && TFIDF < 3.0){
						termTfidf.put(term, TFIDF);
					//}
					docTermTfidf.put(programme.getDegreeUnitCode(), termTfidf);
			}
		}
		
		HashMap<String, SimilarityValue> informationMatrix = new HashMap<>();
		HashMap<String, Double> values1 = new HashMap<>();
		HashMap<String, Double> values2 = new HashMap<>();
		
		
		for (DegreeProgramme programme1: programmes){
			for (DegreeProgramme programme2 : programmes){
				if(!programme1.equals(programme2)){
					values1 = (HashMap<String, Double>) docTermTfidf.get(programme1.getDegreeUnitCode()).clone();
					values2 = (HashMap<String, Double>) docTermTfidf.get(programme2.getDegreeUnitCode()).clone();
					
					//fill in missing data
					if (values2.keySet() != null){
						for(String term : values2.keySet()){
							if(!values1.containsKey(term)){
								values1.put(term, 0.0);
							}
						}
					}
					
					if(values1.keySet() != null){
						for(String term : values1.keySet()){
							if(!values2.containsKey(term)){
								values2.put(term, 0.0);
							}
						}
					}

					Map<String, Double> sortedValues1 = new TreeMap<String, Double>(values1);
					Map<String, Double> sortedValues2 = new TreeMap<String, Double>(values2);
					
					double similarityByTitle = cosineSimilarity(sortedValues1.values(), sortedValues2.values());
					SimilarityValue sv = new SimilarityValue();
					sv.setProgramme1(programme1.getDegreeUnitCode());
					sv.setProgramme2(programme2.getDegreeUnitCode());
					sv.setValue(similarityByTitle);
					if(!informationMatrix.containsKey(programme1.getDegreeUnitCode() + "," + programme2.getDegreeUnitCode()) && 
					   !informationMatrix.containsKey(programme2.getDegreeUnitCode() + "," + programme1.getDegreeUnitCode())){
							informationMatrix.put(programme1.getDegreeUnitCode() + "," + programme2.getDegreeUnitCode(), sv);
					}
				}
			}
		}
		return informationMatrix;
	}
	
	@SuppressWarnings("unchecked")
	public  HashMap<String, SimilarityValue> createQualificationMatrix(){
		int noOfDocsContainingTerm = 0;
		HashMap<String, HashMap<String, Double>> docTermTfidf = new HashMap<>();
		Double TFIDF = 0.0;
		for (DegreeProgramme programme : programmes) {
			HashMap<String, Double> termTfidf = new HashMap<>();
			for(String term: programme.getQualification().split("\\s+")){
					noOfDocsContainingTerm = calculateNoOfDocsContainingTerm(term, "qualification");
					TFIDF = calculateTFIDF(programme.getQualification(), term, noOfDocsContainingTerm);
					//if(TFIDF > 1.0 && TFIDF < 3.0){
						termTfidf.put(term, TFIDF);
					//}
					docTermTfidf.put(programme.getDegreeUnitCode(), termTfidf);
			}
		}
		
		
		HashMap<String, SimilarityValue> qualificationMatrix = new HashMap<>();
		HashMap<String, Double> values1 = new HashMap<>();
		HashMap<String, Double> values2 = new HashMap<>();
		
		
		for (DegreeProgramme programme1: programmes){
			for (DegreeProgramme programme2 : programmes){
				if(!programme1.equals(programme2)){
					values1 = (HashMap<String, Double>) docTermTfidf.get(programme1.getDegreeUnitCode()).clone();
					values2 = (HashMap<String, Double>) docTermTfidf.get(programme2.getDegreeUnitCode()).clone();
					
					//fill in missing data
					if (values2.keySet() != null){
						for(String term : values2.keySet()){
							if(!values1.containsKey(term)){
								values1.put(term, 0.0);
							}
						}
					}
					
					if(values1.keySet() != null){
						for(String term : values1.keySet()){
							if(!values2.containsKey(term)){
								values2.put(term, 0.0);
							}
						}
					}

					Map<String, Double> sortedValues1 = new TreeMap<String, Double>(values1);
					Map<String, Double> sortedValues2 = new TreeMap<String, Double>(values2);
					
					double similarityByTitle = cosineSimilarity(sortedValues1.values(), sortedValues2.values());
					SimilarityValue sv = new SimilarityValue();
					sv.setProgramme1(programme1.getDegreeUnitCode());
					sv.setProgramme2(programme2.getDegreeUnitCode());
					sv.setValue(similarityByTitle);
					if(!qualificationMatrix.containsKey(programme1.getDegreeUnitCode() + "," + programme2.getDegreeUnitCode()) && 
					   !qualificationMatrix.containsKey(programme2.getDegreeUnitCode() + "," + programme1.getDegreeUnitCode())){
							qualificationMatrix.put(programme1.getDegreeUnitCode() + "," + programme2.getDegreeUnitCode(), sv);
					}
				}
			}
		}
		return qualificationMatrix;
	}
	

	private int calculateNoOfDocsContainingTerm(String term, String FLAG) {
		int noOfDocs = 0;
		switch (FLAG) {
		case "title":
			for (DegreeProgramme programme: programmes){
				if(programme.getDegreeProgrammeTitle().contains(term))
					noOfDocs++;
			}
			break;
		case "information":
			for (DegreeProgramme programme: programmes){
				if(programme.getInformation().contains(term))
					noOfDocs++;
			}
			break;
		case "qualification":
			for (DegreeProgramme programme: programmes){
				if(programme.getQualification().contains(term))
					noOfDocs++;
			}
			break;		
		default:
			break;
		}
		return noOfDocs;
	}
	
	public Double calculateTFIDF(String information, String term, int noOfDocsContainingTerm){
		return calculateTF(information, term) * calculateIDF(term, noOfDocsContainingTerm);
	}
	
	public Double calculateTF(String information, String term){
		//logarithmically scaled frequency
		int i=0;
		Pattern p = Pattern.compile(term);
		Matcher m = p.matcher(information);
		while(m.find()) i++;
		
		//return 1 + Math.log(i);
		
		//normalized TF
		return (double)i/information.split("\\s+").length;
	}
	
	public Double calculateIDF(String term, int noOfDocsContainingTerm){
		Double result = 1 + Math.log(programmes.size()/noOfDocsContainingTerm);
		return result;
	}
	
	
}
