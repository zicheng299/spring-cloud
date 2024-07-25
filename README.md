#git 上传项目
1.远程仓库创建项目
2.对本地项目初始化
git init
git add *
git commit -m "提交记录"
git branch -M main
git remote add origin https://github.com/zicheng299/spring-cloud.git
git remote -v 查看远程路径，如果是HTTP需要修改为ssh
git remote set-url origin git@github.com:zicheng299/spring-cloud.git
3.进入idea，对项目进行push
