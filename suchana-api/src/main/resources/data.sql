-- insert tag data
insert into tag(id, name) values (1, 'Sports');
insert into tag(id, name) values (2, 'Politics');
insert into tag(id, name) values (3, 'Science');
insert into tag(id, name) values (4, 'Entertainment');

-- insert categories
insert into category(id, name) values (1, 'Sports');
insert into category(id, name) values (2, 'Politics');
insert into category(id, name) values (3, 'Entertainment');

-- insert author
insert into author(id, firstName, lastName, username) values (1, 'Saurav', 'Shrestha', 'sauravshrestha');
insert into author(id, firstName, lastName, username) values (2, 'Dhiraj', 'Chhetri', 'dhirajchhetri');
insert into author(id, firstName, lastName, username) values (3, 'Roshan', 'Dhakal', 'roshandahakal');
insert into author(id, firstName, lastName, username) values (4, 'Nabin', 'Thapa', 'nabinthapa');

-- insert author with category
insert into author_category(author_id, category_id) values (1,1);
insert into author_category(author_id, category_id) values (1,3);
insert into author_category(author_id, category_id) values (2,3);
insert into author_category(author_id, category_id) values (3,1);
insert into author_category(author_id, category_id) values (3,2);
insert into author_category(author_id, category_id) values (4,2);

-- insert into article
insert into article(id, title, content, publishDate, noOfViews, author_id, category_id) values (1, 'Title', 'This is content','2019-07-29T16:50:17.538', 0, 1, 1);
insert into article(id, title, content, publishDate, noOfViews, author_id, category_id) values (2, 'Title1', 'This is content of another story', '2019-07-29T15:51:17.538', 0, 3, 2);

-- insert article_tag
insert into article_tag(article_id, tag_id) values (1,1);
insert into article_tag(article_id, tag_id) values (2,2);