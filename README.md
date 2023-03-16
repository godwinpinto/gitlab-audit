# gitlab-data-downloader
This repository helps download important data nodes (issues, milestones, notes, groups, projects, etc) from your gitlab server using gitlab REST API to a mongodb platform. The primary goal is to facilitate data so that one can create dashboards to monitor proper usage of organizations standard.

### One may ask why mongodb?
The REST API provided by gitlab would have results in nested structure. One could directly write SQL to Gitlab's relational DB. But the chances of breaking on gitlab version updates would be higher. Retreiving from REST API and inserting in mongo reduces alot of dumping work and querying is not that difficult too, if one is aware of NoSQL queries

E.x. An issue labelled as Bug, would ideally need to have a severity and environment label 

#### Origination of the idea:

##### 1. Standarization of labels
While gitlab offers a general way of creating issues and adding unlimited tags to an issue, the organization would benefit from standardizing tags which help to derive useful information.

##### 2. Derive utilitization aread
Know what your team member has been spending most amount of time on (e.x. Person 'A' spends more time on bug resolution). This helps to understand and realign team to tasks

##### 3. Derive productivity
Know what your team member has been spending most amount of time on (e.x. Person 'A' spends more time on bug resolution). This helps to understand and realign team to tasks

## Example Queries: 
Coming soon

