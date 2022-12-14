# Customer rewards

## getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.


## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:


cd existing_repo
git remote add origin "url"
git branch -M "branch name"
git push -uf origin "tmo main"

This service contain 3 end points called
1) Get ("/rewards/{customerID}"): This end point provides last 3 months rewards points based on there transactions spend with respective to the customer.
2) Get("/transactions"): This end point provides total amount of transactions done by the each individual customers
3) Get(""/rewards"): This end point provides total amount of rewards earned by the each individal customers.



