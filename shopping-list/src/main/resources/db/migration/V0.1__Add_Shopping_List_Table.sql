create table SHOPPING_LIST (
  ID UUID PRIMARY KEY,
  NAME TEXT
);

create table COCKTAIL (
  ID UUID PRIMARY KEY,
  ID_DRINK TEXT,
  NAME TEXT,
  INGREDIENTS TEXT
);

create table COCKTAIL_SHOPPING_LIST (
  COCKTAIL_ID UUID REFERENCES COCKTAIL(id),
  SHOPPING_LIST_ID UUID REFERENCES SHOPPING_LIST(id)
);
