INSERT INTO public.role (id, type)
VALUES (DEFAULT, 'walker');
INSERT INTO public.role (id, type)
VALUES (DEFAULT, 'owner');

INSERT INTO public.contact (id, e_mail, city, firstname, lastname, additional_information, photo_data)
VALUES (DEFAULT, 'olegtrofimov@gmail.com', 'Tartu', 'Oleg', 'Trofimov', null, null);
INSERT INTO public.contact (id, e_mail, city, firstname, lastname, additional_information, photo_data)
VALUES (DEFAULT, 'vladislavjagu@gmail.com', 'Tartu', 'Vlad', 'Jagur', null, null);

INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 1, 1, 'oleg', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 2, 'vlad', '123');

INSERT INTO public.city (id, name)
VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name)
VALUES (DEFAULT, 'Tartu');
INSERT INTO public.city (id, name)
VALUES (DEFAULT, 'Narva');
INSERT INTO public.city (id, name)
VALUES (DEFAULT, 'Pärnu');
INSERT INTO public.city (id, name)
VALUES (DEFAULT, 'Kohtla-Järve');
INSERT INTO public.city (id, name)
VALUES (DEFAULT, 'Viljandi');
INSERT INTO public.city (id, name)
VALUES (DEFAULT, 'Maardu');
INSERT INTO public.city (id, name)
VALUES (DEFAULT, 'Rakvere');
INSERT INTO public.city (id, name)
VALUES (DEFAULT, 'Kuressaa');
INSERT INTO public.city (id, name)
VALUES (DEFAULT, 'Sillamäe');

INSERT INTO public.size (id, type, price)
VALUES (DEFAULT, 'Small(0-7 kg)', 5);
INSERT INTO public.size (id, type, price)
VALUES (DEFAULT, 'Medium(7-15 kg)', 7);
INSERT INTO public.size (id, type, price)
VALUES (DEFAULT, 'Large(15-30 kg)', 10);
INSERT INTO public.size (id, type, price)
VALUES (DEFAULT, 'Extra Large(30+ kg)', 13);

INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Akita');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Australian Shepherd');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Basset Hound');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Beagle');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Belgian Malinois');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Bernese Mountain Dog');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Bichon Frise');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Bloodhound');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Border Collie');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Boston Terrier');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Boxer');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Brittany');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Bulldog');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Cane Corso');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Cavalier King Charle');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Chesapeake Bay Retri');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Chihuahua');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Cocker Spaniel');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Collie');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Dachshund');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Doberman Pinscher');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'English Springer Spa');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'French Bulldog');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'German Shepherd');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'German Shorthaired P');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Golden Retriever');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Great Dane');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Havanese');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Labrador Retriever');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Maltese');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Mastiff');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Miniature American S');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Miniature Schnauzer');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Newfoundland');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Pembroke Welsh Corgi');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Pomeranian');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Poodle');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Pug');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Rhodesian Ridgeback');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Rottweiler');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Saint Bernard');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Shetland Sheepdog');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Shiba Inu');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Shih Tzu');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Siberian Husky');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Soft-Coated Wheaten');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Vizsla');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Weimaraner');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'West Highland White');
INSERT INTO public.breed (id, name)
VALUES (DEFAULT, 'Yorkshire Terrier');

INSERT INTO public.dog (id, user_id, breed_id, size_id, name, age, additional_information, dog_photo, status) VALUES (DEFAULT, 2, 4, 3, 'Charlie', 5, 'Big Beagle', null, 'A');
INSERT INTO public.dog (id, user_id, breed_id, size_id, name, age, additional_information, dog_photo, status) VALUES (DEFAULT, 1, 38, 1, 'Valera', 28, 'Big Papa Valera', null, 'A');
insert into public.dog (id, user_id, breed_id, size_id, name, age, additional_information, dog_photo, status) values (DEFAULT, 2, 3, 2, 'NotActiveTest', 7, 'Test to not active dog', null, 'I');


insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-06', '2022-12-06', 10, 11, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-06', '2022-12-06', 10, 11, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-01', '2022-12-06', 10, 11, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-01', '2022-12-06', 10, 11, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-01', '2022-12-06', 10, 11, 'I');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-06', '2022-12-06', 9, 23, 'I');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-13', '2022-12-13', 9, 19, 'I');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-13', '2022-12-13', 9, 19, 'I');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-13', '2022-12-13', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-13', '2022-12-13', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 2, '2022-12-19', '2022-12-19', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-13', '2022-12-13', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 3, 1, '2022-12-13', '2022-12-13', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-12', '2022-12-12', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 2, '2022-12-13', '2022-12-13', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 2, '2022-12-14', '2022-12-16', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 1, '2022-12-08', '2022-12-12', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 4, '2022-12-13', '2022-12-13', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 4, '2022-12-13', '2022-12-13', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 4, '2022-12-13', '2022-12-13', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 4, '2022-12-13', '2022-12-13', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 4, '2022-12-13', '2022-12-13', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 10, '2022-12-13', '2022-12-13', 9, 19, 'A');
insert into public.walking (id, user_id, city_id, date_from, date_to, time_from, time_to, status) values (DEFAULT, 1, 5, '2022-12-13', '2022-12-16', 10, 23, 'A');





insert into public.walking_size (id, walking_id, size_id) values (DEFAULT, 1, 1);
insert into public.walking_size (id, walking_id, size_id) values (DEFAULT, 1, 2);
insert into public.walking_size (id, walking_id, size_id) values (DEFAULT, 1, 3);
insert into public.walking_size (id, walking_id, size_id) values (DEFAULT, 1, 4);
insert into public.walking_size (id, walking_id, size_id) values (DEFAULT, 2, 2);
insert into public.walking_size (id, walking_id, size_id) values (DEFAULT, 3, 3);
insert into public.walking_size (id, walking_id, size_id) values (DEFAULT, 4, 1);
insert into public.walking_size (id, walking_id, size_id) values (DEFAULT, 4, 3);
insert into public.walking_size (id, walking_id, size_id) values (DEFAULT, 4, 4);
insert into public.walking_size (id, walking_id, size_id) values (DEFAULT, 5, 2);
insert into public.walking_size (id, walking_id, size_id) values (DEFAULT, 5, 3);
