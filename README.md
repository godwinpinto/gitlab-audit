# gitlab-etl
The project aims to download important data nodes (issues, milestones, notes, groups, projects, etc) from your gitlab server using gitlab REST API to a mongodb database. The primary goal is to facilitate custom reporting so that one can create dashboards to monitor proper labelling / usage of organizations standard. Extending to even performance monitoring of dev teams.

### One may ask why mongodb?
The REST API provided by gitlab would have results in nested structure. One could directly write SQL to Gitlab's relational DB. But the chances of breaking on gitlab version updates would be higher. Retreiving from REST API and inserting in mongo reduces alot of dumping work and querying is not that difficult too, if one is aware of NoSQL queries

E.x. An issue labelled as Bug, would ideally need to have a severity and environment label too

## How to setup: 
1. Clone the repo
2. Make sure the user being used has the top most group level and atleast maintainer access to get details of all groups / sub projects to download with the API. 
3. Gitlab API key: Go to profile->preference->access key-> tick (api, read_api, read_user, read_repository) and mark the expiry date and generate token
4. For super quick start with mongodb database test environment get a free instance at www.mongodb.com
5. define the environment variables i.e.
GITLAB_API_URL=&lt;YOUR GITLAB URL&gt;, GITLAB_TOKEN=&lt;YOUR GITLAB TOKEN&gt;, MONGODB_URL=&lt;YOUR MONGODB URL&gt;, MONGODB_USER=&lt;YOUR MONGODB USERNAME&gt;, MONGODB_PASSWORD=&lt;YOUR MONGODB PASSWORD&gt;, MONGODB_NAME=&lt;YOUR MONGODB DATABASE NAME&gt;
6. Incase you need to setup the spring batch history into a permanent database. modify the database details accordingly in application.yml (datasource.url, etc)
7. mvn spring-boot:run to test changes
8. mvn package
9. Sample docker image is provided

## Known Limitations:
Gitlab API fetches max of 100 records at a time, you can tune the concurrency for processing in file com.gp.gdd.config.BatchConfiguration.java, search for "chunk"

## Reporting Usage:
Coming soon

## Related articles:
https://godwin-pinto.medium.com/how-well-maintained-are-your-git-management-processes-9edb4ffed6e6

## Roadmap
1. Unit Test
2. Incremental download of data dump(Currently the programs cleans and download full dump using API)
3. Interruption in service calls leading to full restart
4. Integration with GitHub
5. Integration with Jira & Bitbucket
