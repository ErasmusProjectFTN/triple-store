<h1>Erasmus project triple store service</h1>

This repository is part of the FTN Erasmus student mobility project.

<h1>Getting started:</h1>

<h2>Project preparation</h2>
<ul>
  <li>Clone this repository</li>
  <li>From the cloned repository import maven project into IDE of choice (Intellij recommended)</li>
</ul>
<h2>Server preparation</h2>
<ul>
  <li>Download apache-jena-fuseki 2.4.1 (SPARQL server) -> <a href = "https://archive.apache.org/dist/jena/binaries/apache-jena-fuseki-2.4.1.zip" > Here </a></li> 
  <li><b>NOTE</b> apache-jena-fuseki, and apache-jena (semantic web framework used within the application) versions must match, for the application to function properly</li>
  <li>Unpack fuseki</li>
  <li>Position to the folder that contains apache-jena-fuseki in terminal</li>
  <li>To start server use one of the following commands ((1) or (2)). (1) is best suited for testing, as it starts the server without permanent data persistence (all data is lost after shutdown or restart), so deployment and CRUD operations should run slightly faster. (2) is for regular use, where all data is persisted in a .ttl file. Apache-jena-fuseki can also work in combination with MySQL, but that option hasn't been fully explored currently.
    <ol>
      <li>fuseki-server --update --mem /<b><i><u>name-of-dataset</b></i></u> where name-of-dataset represents the endpoint referenced in CRUD operations</li>
      <li>fuseki-server --config=<b><i><u>name-of-file.ttl</b></i></u> where name-of-file is the name of the .ttl file used for storage</li>
    </ol>
  </li>
</ul> 
<h2>App deployment</h2>
  <ul>
    <li>Project preparation</li>
    <li>Server preparation</li>
    <li>From triple-store project run TripleStoreServiceApplication.java which will start the spring app</li>
  </ul>

The rest of the project can be found -> <a href = "https://github.com/ErasmusProjectFTN" > Here </a></li> 
More specifically:
File storage -> <a href = "https://github.com/ErasmusProjectFTN/file-storage" > Here </a></li> 
Client side -> <a href = "https://github.com/ErasmusProjectFTN/Client" > Here </a></li>
Microservice configuration -> <a href = "https://github.com/ErasmusProjectFTN/api-gateway-service" > Here </a></li>, <a href = "https://github.com/ErasmusProjectFTN/config-files" > here </a></li>, <a href = "https://github.com/ErasmusProjectFTN/service-registry" > here </a></li>, and <a href = "https://github.com/ErasmusProjectFTN/config-server" > here </a></li>
