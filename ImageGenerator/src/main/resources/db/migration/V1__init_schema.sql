-- V1__create_users_table.sql

CREATE TABLE users (
                       user_id UUID PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(50) NOT NULL UNIQUE,
                       hashed_password CHAR(60) NOT NULL,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       last_login TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       is_verified BOOLEAN NOT NULL DEFAULT FALSE,
                       role VARCHAR(15) NOT NULL
);

-- Grant privileges and set table owner
ALTER TABLE users OWNER TO datnguyen;

GRANT ALL PRIVILEGES ON TABLE users TO datnguyen;
