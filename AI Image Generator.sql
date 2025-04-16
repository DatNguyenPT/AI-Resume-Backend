create table users(
	user_id uuid primary key,
	username varchar(50) not null unique,
	email varchar(50) not null unique,
	hashed_password char(60) not null,
	created_at timestamp not null,
	last_login timestamp not null,
	is_verified boolean not null, -- verified account or not
	plan_id uuid not null
);

create table generated_image(
	image_id uuid primary key,
	user_id uuid not null,
	prompt text not null,
	model_version varchar(20) not null,
	storage_path varchar(60) not null,
	created_at timestamp not null,
	status varchar(20) not null, --pending, completed, failed
	resolution varchar(20) not null
);

create table subscription_plans(
	plan_id uuid primary key,
	plan_name varchar(10) not null, -- free vs pro
	price decimal(10, 2) not null, -- monthly price (0 for free tier)
	max_images int not null, -- max images per month
	max_resolution varchar(20) not null -- up to 2048x2048
);

create table user_subscriptions(
	subscription_id uuid primary key,
	user_id uuid not null,
	plan_id uuid not null,
	start_date timestamp not null,
	end_date timestamp not null,
	payment_status varchar(20) --paid, unpaid, canceled
);

create table shared_images(
	shared_id uuid primary key,
	image_id uuid not null,
	user_id uuid not null, --image owner
	shared_with uuid not null, -- shared to another user(id)
	shared_at timestamp not null,
	access_level varchar(20) not null --view, download, edit
);

create table activity_logs(
	log_id uuid primary key,
	user_id uuid not null,
	activity_type varchar(50) not null, --login, image_generated, shared
	activity_timestamp timestamp not null, --activity timestamp
	metatdata json not null --addition data e.g: ip to ban suspicious user
);
	
alter table generated_image
add constraint fk_user_id foreign key(user_id) references users(user_id);

alter table user_subscriptions
add constraint fk_user_id foreign key(user_id) references users(user_id);

alter table shared_images
add constraint fk_user_id foreign key(user_id) references users(user_id);

alter table activity_logs
add constraint fk_user_id foreign key(user_id) references users(user_id);

alter table users
drop constraint fk_plan_id
add constraint fk_plan_id foreign key(plan_id) references subscription_plans(plan_id);

alter table user_subscriptions
add constraint fk_plan_id foreign key(plan_id) references subscription_plans(plan_id);

alter table shared_images
add constraint fk_image_id foreign key(image_id) references generated_image(image_id);


ALTER TABLE users
ADD COLUMN role VARCHAR(20);

CREATE OR REPLACE FUNCTION prevent_adding_new_plans()
RETURNS TRIGGER AS $$
BEGIN
    -- Kiểm tra nếu bảng đã có 2 bản ghi, từ chối thao tác INSERT
    IF (SELECT COUNT(*) FROM subscription_plans) >= 2 THEN
        RAISE EXCEPTION 'Cannot insert more than 2 subscription plans.';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER prevent_insert_subscription_plans
    BEFORE INSERT ON subscription_plans
    FOR EACH ROW
    EXECUTE FUNCTION prevent_adding_new_plans();

INSERT INTO subscription_plans (plan_id, plan_name, price, max_images, max_resolution)
VALUES
    ('f8e9b2b3-35c1-45ff-b441-bc3ecf4a45b3'::uuid, 'free', 0.00, 100, '1024x1024'),
    ('e7f7a8d0-f500-46db-88d4-8314c46b7c45'::uuid, 'premium', 19.99, 500, '2048x2048');


select * from subscription_plans
select * from users
select * from user_subscriptions

alter table user_subscriptions
drop column userid;
	
alter table subscription_plans
drop column planid;

alter table users
drop column plan_name;

UPDATE subscription_plans
SET plan_name = 'PREMIUM'
WHERE plan_name = 'premium';

delete from user_subscriptions;
delete from users


