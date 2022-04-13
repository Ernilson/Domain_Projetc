-- CREATE DATABASE `gato`;
USE [gato]
GO
CREATE TABLE dbo.permission (
  [id] bigint NOT NULL IDENTITY,
  [description] varchar(255) DEFAULT NULL,
  PRIMARY KEY ([id])
)  
GO

INSERT INTO dbo.permission ([description]) VALUES
	('ADMIN'),
	('MANAGER'),
	('COMMON_USER')
GO

CREATE TABLE dbo.users (
  [id] bigint NOT NULL IDENTITY,
  [user_name] varchar(255) DEFAULT NULL,
  [full_name] varchar(255) DEFAULT NULL,
  [password] varchar(255) DEFAULT NULL,
  [account_non_expired] BIT NOT NULL DEFAULT 'TRUE',
  [account_non_locked] BIT NOT NULL DEFAULT 'TRUE',
  [credentials_non_expired] BIT NOT NULL DEFAULT 'TRUE',
  [enabled] BIT NOT NULL DEFAULT 'TRUE',
  PRIMARY KEY ([id]),
  CONSTRAINT [uk_user_name] UNIQUE  ([user_name])
)  
GO

INSERT INTO dbo.users ([user_name], [full_name], [password], [account_non_expired], [account_non_locked], [credentials_non_expired], [enabled]) VALUES
	('ernilson', 'Ernilson souza', '$2a$16$9qr2tv0HmXbHBsx.TZFjfux742wCZM32a8Wi6iBqwIqaizlHPuxHS', 'TRUE', 'TRUE', 'TRUE', 'TRUE'),
	('teste', 'Teste teste', '$2a$16$h4yDQCYTy62R6xrtFDWONeMH3Lim4WQuU/aj8hxW.dJJoeyvtEkhK', 'TRUE', 'TRUE', 'TRUE', 'TRUE')
GO

CREATE TABLE dbo.user_permission (
  [id_user] bigint NOT NULL,
  [id_permission] bigint NOT NULL,
  PRIMARY KEY ([id_user],[id_permission])
 ,
  CONSTRAINT [fk_user_permission] FOREIGN KEY ([id_user]) REFERENCES users ([id]),
  CONSTRAINT [fk_user_permission_permission] FOREIGN KEY ([id_permission]) REFERENCES permission ([id])
) 
GO

CREATE INDEX [fk_user_permission_permission] ON user_permission ([id_permission])
GO

INSERT INTO dbo.user_permission ([id_user], [id_permission]) VALUES
	(1, 1),
	(2, 1),
	(1, 2);