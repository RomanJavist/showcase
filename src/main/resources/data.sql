CREATE TYPE showcaseType AS ENUM ('SC_TYPE1', 'SC_TYPE2');
CREATE TYPE itemType AS ENUM ('ITEM_TYPE1', 'ITEM_TYPE2');

CREATE TABLE Showcase (
                          id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                          name varchar(100) NOT NULL,
                          address varchar(100) NOT NULL,
                          type showcaseType,
                          date_create date,
                          date_edit date
);


CREATE TABLE Item (
                        id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                        showcase_id int REFERENCES Showcase(id) ON DELETE SET NULL,
                        position int,
                        name varchar(100) NOT NULL,
                        type itemType,
                        price decimal NOT NULL,
                        date_create date,
                        date_edit date
);

