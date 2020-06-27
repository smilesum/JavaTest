create table employee(
    id int8,
    PRIMARY KEY (id)
);

create table email(
    id int8,
    employee_id int8,
    PRIMARY KEY (id),
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);
