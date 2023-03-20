# gitlab-etl
The project aims to download important data nodes (issues, milestones, notes, groups, projects, etc) from your gitlab server using gitlab REST API to a mongodb database. The primary goal is to facilitate custom reporting so that one can create dashboards to monitor proper labelling / usage of organizations standard.

### One may ask why mongodb?
The REST API provided by gitlab would have results in nested structure. One could directly write SQL to Gitlab's relational DB. But the chances of breaking on gitlab version updates would be higher. Retreiving from REST API and inserting in mongo reduces alot of dumping work and querying is not that difficult too, if one is aware of NoSQL queries

E.x. An issue labelled as Bug, would ideally need to have a severity and environment label too

## How to setup: 
1. Clone the repo
2. define the environment variables i.e.
GITLAB_API_URL=&lt;YOUR GITLAB URL&gt;, GITLAB_TOKEN=&lt;YOUR GITLAB TOKEN&gt;, MONGODB_URL=&lt;YOUR MONGODB URL&gt;, MONGODB_USER=&lt;YOUR MONGODB USERNAME&gt;, MONGODB_PASSWORD=&lt;YOUR MONGODB PASSWORD&gt;, MONGODB_NAME=&lt;YOUR MONGODB DATABASE NAME&gt;
3. Incase you need to setup the spring batch history into a permanent database. modify the database details accordingly in application.yml (datasource.url, etc)
4. mvn spring-boot:run to test changes
5. mvn package

## Known Limitations:
Gitlab API fetches max of 100 records at a time, you can tune the concurrency for processing in file com.gp.gdd.config.BatchConfiguration.java, search for "chunk"

## Reporting Usage:
Coming soon

## Roadmap
1. Unit Test
2. Interruption in service calls
3. Integration with GitHub
4. Integration with Jira & Bitbucket
