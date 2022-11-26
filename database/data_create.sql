INSERT INTO public.role (id, type)
VALUES (DEFAULT, 'walker');
INSERT INTO public.role (id, type)
VALUES (DEFAULT, 'owner');

INSERT INTO public.contact (id, e_mail, city, firstname, lastname, adittion_information, photo_data)
VALUES (DEFAULT, 'olegtrofimov@gmail.com', 'Tartu', 'Oleg', 'Trofimov', null, null);
INSERT INTO public.contact (id, e_mail, city, firstname, lastname, adittion_information, photo_data)
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