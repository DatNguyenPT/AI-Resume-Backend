create table users(
	user_id uuid primary key,
	username varchar(50) not null unique,
	email varchar(50) not null unique,
	hashed_password char(60) not null,
	created_at timestamp not null,
	last_login timestamp not null,
	is_verified boolean not null, -- verified account or not
	role varchar(15) not null
)

select * from users;

GRANT ALL PRIVILEGES ON DATABASE auth TO datnguyen;
ALTER TABLE public.users OWNER TO datnguyen;

