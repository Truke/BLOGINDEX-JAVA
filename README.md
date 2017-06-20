#BLOGINDEX-JAVA

> 这是我用JAVA的SSH框架（Spring+Struts2+Hibernate）写的前后端分离的一个博客项目。其中项目中有用到

* SSH
* MYSQL
* Cleanblog
* Bootstrap
* simditor
* toastr
* validate
* jqgrid
* sweetalert

##sql
   'create database blog;
	create table blog(
		id int primary key auto_increment,
		title varchar(128) not null,
		subtitle varchar(128) not null,
		blog text not null,
		tag varchar(128),
		sort varchar(128),
		createTime varchar(32),
		view int
	);

	create table sort(
		id int primary key auto_increment,
		sort varchar(32) not null
	);

	create table user(
		id int primary key auto_increment,
		user varchar(128) not null,
		password varchar(128) not null
	);

	create table contact(
		id int primary key auto_increment,
		name varchar(128) not null,
		email varchar(128) not null,
		content text not null,
		isread int,
		createtime varchar(32)
	);'