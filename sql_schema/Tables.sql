

CREATE TABLE "Tally" (
    "UserPayer" int   NOT NULL,
    "UserPayee" int   NOT NULL,
    "Bill" varchar(256)   NOT NULL,
    "Amount" float   NOT NULL,
    "Settled" Boolean   NOT NULL,
    CONSTRAINT "pk_Tally" PRIMARY KEY (
        "UserPayer","UserPayee","Bill"
     )
);

CREATE TABLE "Bills" (
    "Bill" varchar(256)   NOT NULL,
    "Store" varchar(256)   NOT NULL,
    "Date" varchar(256)   NOT NULL,
    "Payer" int   NOT NULL,
    "BillInvolved" int[]   NULL,
    CONSTRAINT "pk_Bills" PRIMARY KEY (
        "Bill"
     )
);

CREATE TABLE "ItemSplits" (
    "Item" varchar(256)   NOT NULL,
    "Bill" varchar(256)   NOT NULL,
    "Quantity" int   NOT NULL,
    "Price" float   NOT NULL,
    "ItemInvolved" int[]   NOT NULL,
    CONSTRAINT "pk_ItemSplits" PRIMARY KEY (
        "Item","Bill"
     )
);

-- Restrict users from entering the duplicate product name within a bill.
CREATE TABLE "UserCred" (
    "Username" varchar(256)   NOT NULL,
    "UserId" int   NOT NULL,
    "Password" varchar(256)   NOT NULL,
    "Email" varchar(256)   NOT NULL,
    CONSTRAINT "pk_UserCred" PRIMARY KEY (
        "UserId"
     )
);

CREATE TABLE "UserRoles" (
    "User" int   NOT NULL,
    "Roles" varchar(256)   NOT NULL,
    CONSTRAINT "pk_UserRoles" PRIMARY KEY (
        "User"
     )
);

CREATE TABLE "Friends" (
    "UserTo" int   NOT NULL,
    "UserFrom" int   NOT NULL,
    "Status" int   NOT NULL,
    "Time" varchar(256)   NOT NULL,
    CONSTRAINT "pk_Friends" PRIMARY KEY (
        "UserTo","UserFrom"
     )
);

ALTER TABLE "Tally" ADD CONSTRAINT "fk_Tally_UserPayer" FOREIGN KEY("UserPayer")
REFERENCES "UserCred" ("UserId");

ALTER TABLE "Tally" ADD CONSTRAINT "fk_Tally_UserPayee" FOREIGN KEY("UserPayee")
REFERENCES "UserCred" ("UserId");

ALTER TABLE "Tally" ADD CONSTRAINT "fk_Tally_Bill" FOREIGN KEY("Bill")
REFERENCES "Bills" ("Bill");

ALTER TABLE "ItemSplits" ADD CONSTRAINT "fk_ItemSplits_Bill" FOREIGN KEY("Bill")
REFERENCES "Bills" ("Bill");

ALTER TABLE "UserRoles" ADD CONSTRAINT "fk_UserRoles_User" FOREIGN KEY("User")
REFERENCES "UserCred" ("UserId");

ALTER TABLE "Friends" ADD CONSTRAINT "fk_Friends_UserTo" FOREIGN KEY("UserTo")
REFERENCES "UserCred" ("UserId");

ALTER TABLE "Friends" ADD CONSTRAINT "fk_Friends_UserFrom" FOREIGN KEY("UserFrom")
REFERENCES "UserCred" ("UserId");

