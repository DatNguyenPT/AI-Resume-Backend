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
	start_date timestamp not null,
	end_date timestamp not null,
	payment_status varchar(20) --paid, unpaid, canceled
);

INSERT INTO subscription_plans (plan_id, plan_name, price, max_images, max_resolution)
VALUES
    ('f8e9b2b3-35c1-45ff-b441-bc3ecf4a45b3'::uuid, 'FREE', 0.00, 100, '1024x1024'),
    ('e7f7a8d0-f500-46db-88d4-8314c46b7c45'::uuid, 'PREMIUM', 19.99, 500, '2048x2048');

select * from subscription_plans;
select * from user_subscriptions;


GRANT ALL PRIVILEGES ON DATABASE subscription TO datnguyen;
ALTER TABLE public.subscription_plans OWNER TO datnguyen;
ALTER TABLE public.user_subscriptions OWNER TO datnguyen;

