CREATE DATABASE IF NOT EXISTS bank;
USE bank;

CREATE TABLE IF NOT EXISTS clients
( 
CNP_CUI char(20) NOT NULL UNIQUE PRIMARY KEY,
nume char(20),
adresa char(20)
);

CREATE TABLE IF NOT EXISTS employees
(
idEmpl int UNIQUE auto_increment primary key,
nume char(50),
adresa char(50),
telefon char(50),
username char(50),
parola char(50),
isAdmin bool);



CREATE TABLE IF NOT EXISTS account
(
idAcc char(100) unique primary key,
suma float,
id_client char(50) 
);

CREATE TABLE IF NOT EXISTS tranzactie
(
idTranz int unique auto_increment primary key,
contS char(100),
contD char(100),
tip bool,
id_employee int,
dataT char(50),
suma float,
descriere char(50)
);



alter table account
add constraint fk_account_clients
foreign key (id_client)
references clients(CNP_CUI)
on update cascade
on delete cascade;

alter table tranzactie
add constraint fk_tranzactie_account
foreign key (contS)
references account(idAcc)
on update cascade
on delete cascade;

alter table tranzactie
add constraint fk_tranzactie_account1
foreign key (contD)
references account(idAcc)
on update cascade
on delete cascade;

alter table tranzactie
add constraint fk_tranzactie_exmployees
foreign key (id_employee)
references employees(idEmpl)
on update cascade
on delete cascade;

delimiter //

CREATE TRIGGER insert_cont_client AFTER INSERT ON clients
	FOR EACH ROW BEGIN
		INSERT INTO account(idAcc, suma, id_client) VALUES (NEW.CNP_CUI*101, 0, NEW.CNP_CUI);
END;//
        
delimiter ;



DROP TRIGGER IF EXISTS adauga_tranzactie_creare_cont;

delimiter //

CREATE TRIGGER adauga_tranzactie_creare_cont AFTER INSERT ON account
  FOR EACH ROW BEGIN
    INSERT INTO  tranzactie (contS, contD, tip, id_employee, dataT, suma, descriere) 
    VALUES 
    (NEW.idAcc, NEW.idAcc, false , NULL, CURRENT_DATE(), 0,'Deschidere cont');
  END; //

delimiter ;

INSERT INTO clients 
(CNP_CUI, nume, adresa) 
VALUES
('1950123156935','Popa Ion', 'Str. Mare, Dabuleni, Ilfov'),
('2601219157632','Popescu Maria',  'Blvd. Primaverii, Bucuresti'),
('1990310786543','Andreescu Victor', 'Blvd. Iuliu Maniu, Bucuresti'),
('2950617864545','Predescu Andreea', 'Str. Virtutii, Baia Mare'),
('2980716543432','Ionescu Mihaela', 'Str. Visinilor, Bucuresti'),
('1890726554432','Dinu Cornel', 'Calea Victoriei, Bucuresti'),
('23446788','Orange S.A','Bucuresti'),
('28946368','Electrica S.A','Bucuresti'),
('16945971','E.ON S.A','Cluj-Napoca'),
('92369498','CAA S.A','Cluj-Napoca');


INSERT INTO employees 
(nume, adresa, telefon, username, parola, isAdmin) 
VALUES
('Jesse Cole', '12557 Daystar Parkway', '62-(615)720-3591','jcole0@is.gd', 'parola1',true),
('Kenneth Sullivan', '289 Maple Wood Hill', '420-(246)883-1509','ksullivan1@shinystat.com','parola2',false),
('Denise Butler', '7610 Continental Drive', '358-(654)301-8610','dbutler2@google.co.jp','parola3',false),
('Margaret Henderson', '78483 Reindahl Court', '55-(101)544-8762','mhenderson3@macromedia.com','parola4',false),
('Anthony Sanchez', '2 Old Gate Way', '62-(776)174-7428','asanchez4@baidu.com','parola5',false),
('Ann Robinson', '89 Bay Plaza', '7-(738)930-1737','arobinson5@go.com','parola6',false),
('Doris Meyer', '93268 Moose Plaza', '86-(121)279-3985','dmeyer6@e-recht24.de','parola7',false),
('Joan Bradley', '9728 Grayhawk Terrace', '46-(345)602-7270','jbradley7@google.co.jp','parola8',false),
('Sean Wheeler', '39953 Toban Hill', '1-(661)824-4437','swheeler8@huffingtonpost.com','parola9',false),
('Gregory Adams', '4441 Moulton Street', '55-(816)352-7024','gadams9@weather.com','parola10',false);




DROP PROCEDURE IF EXISTS TRANSFER_INTRE_CONTURI;

DELIMITER //

CREATE PROCEDURE 
   TRANSFER_INTRE_CONTURI(cont_sursa_cod char(100), cont_destinatie_cod char(100),  valoare_transfer float, detaliu_transfer char(50), user_id int)   
	
  BEGIN
    START TRANSACTION; 
    	    SET @ID_S = NULL, @ID_D = NULL, @VAL = NULL, @ID_TIP1 = NULL, @ID_USER=user_id;
    	    SELECT @ID_S := idAcc FROM account WHERE idAcc = cont_sursa_cod;
    	    SELECT @ID_D := idAcc FROM account WHERE idAcc = cont_destinatie_cod;
    	    SELECT @VAL := suma FROM account WHERE idAcc = @ID_S;
    	    #SELECT @ID_TIP1 := tip FROM tranzactie WHERE tip = true;
    	    

    	    IF (@VAL < valoare_transfer) THEN 	
		    BEGIN
			INSERT INTO 
                tranzactie (contS, contD, tip, id_employee, dataT, suma, descriere)
			    VALUES
			    (@ID_S, @ID_D, true, @ID_USER, CURRENT_DATE(), 0, detaliu_transfer);
		    	COMMIT;
		    END;
	    ELSEIF (@ID_S IS NOT NULL AND @ID_D IS NOT NULL) THEN 	
		    BEGIN
			INSERT INTO tranzactie (contS, contD, tip, id_employee, dataT, suma, descriere)
			    VALUES
			    (@ID_S, @ID_D, true,@ID_USER, CURRENT_DATE(), valoare_transfer,detaliu_transfer);
			    
			UPDATE account SET suma = suma - valoare_transfer WHERE idAcc = @ID_S;
			
   			UPDATE account SET suma = suma + valoare_transfer WHERE idAcc = @ID_D;
   			
			COMMIT;
		    END;

	   ELSE ROLLBACK;
    	   END IF;
  END //
DELIMITER ;

call TRANSFER_INTRE_CONTURI("1711543071","190963381997632",50,"tranzactie",2);
select * from account;