create table Category(
	id int, 
	[name] nvarchar(50),
	[desc] nvarchar(50),
	image varchar(100),
	category varchar(50),
	primary key (id)
)

create table Product(
	id int,
	sale int,
	[image] varchar(100),
	[label] nvarchar(50),
	[name] nvarchar(100),
	oldPrice int,
	newPrice int,
	[desc] nvarchar(150),
	categoryId int,
	primary key (id),
	FOREIGN KEY (categoryId) REFERENCES Category(id)
)

create table Video(
	id int,
	link varchar(200),
	primary key (id)
)

create table DiscountCode(
	id int,
	code varchar(50),
	[value] int,
	[status] varchar(50),
	[time] int,
	[from] varchar(50),
	[to] varchar(50),
	primary key (id)
)

insert into Category values (1, 'Sofa gỗ')
insert into Category values (2, 'Kệ tivi')
insert into Category values (3, 'Sofa gỗ')
insert into Category values (4, 'Sofa gỗ')
insert into Category values (5, 'Sofa gỗ')
insert into Category values (6, 'Sofa gỗ')
insert into Category values (7, 'Sofa gỗ')
insert into Category values (8, 'Sofa gỗ')
insert into Category values (9, 'Sofa gỗ')
insert into Category values (10, 'Sofa gỗ')
