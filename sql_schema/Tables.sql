

CREATE TABLE "tally" (
    "user_payer" int   NOT NULL,
    "user_payee" int   NOT NULL,
    "bill" varchar(256)   NOT NULL,
    "amount" float   NOT NULL,
    "settles" Boolean   NOT NULL,
    CONSTRAINT "pk_Tally" PRIMARY KEY (
        "user_payer","user_payee","bill"
     )
);

CREATE TABLE "bills" (
    "bill" varchar(256)   NOT NULL,
    "store" varchar(256)   NOT NULL,
    "date" varchar(256)   NOT NULL,
    "payer" int   NOT NULL,
    "bill_involved" int[]   NULL,
    CONSTRAINT "pk_Bills" PRIMARY KEY (
        "bill"
     )
);

CREATE TABLE "item_splits" (
    "item" varchar(256)   NOT NULL,
    "bill" varchar(256)   NOT NULL,
    "quantity" int   NOT NULL,
    "price" float   NOT NULL,
    "item_involved" int[]   NOT NULL,
    CONSTRAINT "pk_ItemSplits" PRIMARY KEY (
        "item","bill"
     )
);

-- Restrict users from entering the duplicate product name within a bill.
CREATE TABLE "user_cred" (
    "user_name" varchar(256)   NOT NULL,
    "user_id" SERIAL NOT NULL,
    "password" varchar(256)   NOT NULL,
    "email" varchar(256)  NOT NULL,
    CONSTRAINT "pk_UserCred" PRIMARY KEY (
        "user_id"
     ),
	CONSTRAINT "uc_UserCred_Email" UNIQUE (
        "email"
    )
);

CREATE TABLE "user_roles" (
    "id" SERIAL NOT NULL,
    "user_id" int   NOT NULL,
    "roles" varchar(256)   NOT NULL,
    CONSTRAINT "pk_IdUserRoles" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "friends" (
    "user_to" int   NOT NULL,
    "user_from" int   NOT NULL,
    "status" int   NOT NULL,
    "time" varchar(256)   NOT NULL,
    CONSTRAINT "pk_Friends" PRIMARY KEY (
        "user_to","user_from"
     )
);

ALTER TABLE "tally" ADD CONSTRAINT "fk_Tally_UserPayer" FOREIGN KEY("user_payer")
REFERENCES "user_cred" ("user_id");

ALTER TABLE "tally" ADD CONSTRAINT "fk_Tally_UserPayee" FOREIGN KEY("user_payee")
REFERENCES "user_cred" ("user_id");

ALTER TABLE "tally" ADD CONSTRAINT "fk_Tally_Bill" FOREIGN KEY("bill")
REFERENCES "bills" ("bill");

ALTER TABLE "item_splits" ADD CONSTRAINT "fk_ItemSplits_Bill" FOREIGN KEY("bill")
REFERENCES "bills" ("bill");

ALTER TABLE "user_roles" ADD CONSTRAINT "fk_UserRoles_User" FOREIGN KEY("user_id")
REFERENCES "user_cred" ("user_id");

ALTER TABLE "friends" ADD CONSTRAINT "fk_Friends_UserTo" FOREIGN KEY("user_to")
REFERENCES "user_cred" ("user_id");

ALTER TABLE "friends" ADD CONSTRAINT "fk_Friends_UserFrom" FOREIGN KEY("user_from")
REFERENCES "user_cred" ("user_id");

