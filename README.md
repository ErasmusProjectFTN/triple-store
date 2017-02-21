<h1>Erasmus project triple store service</h1>

<h2>How to deploy</h2>
<ol>
  <li>Clone this repository</li>
  <li>Download apache-jena-fuseki 2.4.1 -> <a href = "https://archive.apache.org/dist/jena/binaries/apache-jena-fuseki-2.4.1.zip" > Here </a></li>
  <li>Unpack fuseki</li>
  <li>Position to upacked folder in command prompt and depoy server with one of the following commands:
      <p>fuseki-server --update --mem /name-of-dataset</p>
      <p>fuseki-server --config=name-of-file.ttl</p>
  </li>
  <li>From triple-store project run TripleStoreServiceApplication.java</li>
</ol> 
