setup:
	## Setup Challenge Envrionment
	@cd out/ && cp globo-challenge.jar ../globo-challenge.jar

challenge:
	## Starting the challenge application
	@java -jar globo-challenge.jar --input-file $(INPUT-FILE)
