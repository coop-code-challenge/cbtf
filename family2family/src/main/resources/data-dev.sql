-- noinspection SqlNoDataSourceInspectionForFile

--reference data
INSERT INTO CATEGORY(CATEGORY_ID, ACTIVE, DESCRIPTION) VALUES
(1, TRUE, 'Physical Challenges'),
(2, TRUE, 'Treatments'),
(3, TRUE, 'Educational Issues'),
(4, TRUE, 'Behavioral/Cognative Issues'),
(5, TRUE, 'Environment'),
(6, TRUE, 'Organizations');

INSERT INTO SUBCATEGORY(SUBCATEGORY_ID, ACTIVE, DESCRIPTION, CATEGORY_ID) VALUES
(123, TRUE, 'Ventilator', 2),
(124, TRUE, 'Walker', 2),
(125, TRUE, 'Wheelchair', 2),
(126, TRUE, 'IEP', 3),
(127, TRUE, '504 Plan', 3),
(128, TRUE, 'Grades', 3),
(129, TRUE, 'Home Tutored / Schooled', 3),
(130, TRUE, 'Homework Issues', 3),
(131, TRUE, 'Mobility Services', 3),
(132, TRUE, 'Orientation Services', 3),
(133, TRUE, 'Reading Services', 3),
(134, TRUE, 'Special Education', 3),
(135, TRUE, 'Speech Services/Therapy', 3),
(136, TRUE, 'Studying / Concentration', 3),
(137, TRUE, 'Visual Services', 3),
(138, TRUE, 'Adaptive Behavior', 4),
(139, TRUE, 'ADHD', 4),
(140, TRUE, 'Anger Issues', 4),
(141, TRUE, 'Anxiety', 4),
(142, TRUE, 'Auditory Processing', 4),
(143, TRUE, 'Behavior - General', 4),
(144, TRUE, 'Cognitive Issues', 4),
(145, TRUE, 'Counseling', 4),
(146, TRUE, 'Delayed Constructional Reasoning', 4),
(147, TRUE, 'Delayed Spatial Reasoning', 4),
(148, TRUE, 'Depression', 4),
(149, TRUE, 'Expressive Aphasia', 4),
(150, TRUE, 'Low IQ', 4),
(151, TRUE, 'Memory Issues', 4),
(152, TRUE, 'Motor Skills', 4),
(153, TRUE, 'Poor Judgement', 4),
(154, TRUE, 'Poor Reflexes', 4),
(155, TRUE, 'Psychologist Visits', 4),
(156, TRUE, 'Psychosocial', 4),
(157, TRUE, 'Puberty', 4),
(158, TRUE, 'Self-Control Issues', 4),
(159, TRUE, 'Self-Esteem', 4),
(160, TRUE, 'Shyness', 4),
(161, TRUE, 'Sleep Issues', 4),
(162, TRUE, 'Social Anxiety / Struggles', 4),
(163, TRUE, 'Social Worker', 4),
(164, TRUE, 'Speech Impairment', 4),
(165, TRUE, 'Adopted', 5),
(166, TRUE, 'College', 5),
(167, TRUE, 'Death in Family', 5),
(168, TRUE, 'Depression - Family Member', 5),
(169, TRUE, 'Divorce', 5),
(170, TRUE, 'Grandparent(s) - Custodial', 5),
(171, TRUE, 'Only Child', 5),
(172, TRUE, 'Puberty', 5),
(173, TRUE, 'School-Aged', 5),
(174, TRUE, 'Siblings', 5),
(175, TRUE, 'Single Father', 5),
(176, TRUE, 'Single Mother', 5),
(177, TRUE, 'Teen', 5),
(178, TRUE, 'AI Dupont Delaware', 6),
(179, TRUE, 'Boston Children''s Hospital - BCH', 6),
(180, TRUE, 'Camp Sunshine', 6),
(181, TRUE, 'CBTF', 6),
(182, TRUE, 'Children''s Hospital Central California', 6),
(183, TRUE, 'Children''s Hospital Los Angeles - CHLA', 6),
(184, TRUE, 'Children''s Hospital Madera', 6),
(185, TRUE, 'Children''s Hospital of Philadelphia - CHOP', 6),
(186, TRUE, 'Commission for Blind', 6),
(187, TRUE, 'Emanuel Cancer Center New Jersey', 6),
(188, TRUE, 'Huntington Hospital', 6),
(189, TRUE, 'Make A Wish Foundation', 6),
(190, TRUE, 'Memorial Sloan Kettering Cancer Center - MSKCC', 6),
(191, TRUE, 'Memphis Legal Aspects', 6),
(192, TRUE, 'Seattle Children''s Hospital - SCH', 6),
(193, TRUE, 'St. Louis Children''s Hospital - SLCH', 6);
INSERT INTO SUBCATEGORY(SUBCATEGORY_ID, ACTIVE, DESCRIPTION, CATEGORY_ID) VALUES
(1, TRUE, 'Allergic Reaction - Medication', 1),
(2, TRUE, 'Allergic Reaction - Chemo', 1),
(3, TRUE, 'Anaplastic Ependymoma', 1),
(4, TRUE, 'Aneurysm', 1),
(5, TRUE, 'Anorexia', 1),
(6, TRUE, 'Astrocytoma', 1),
(7, TRUE, 'Ataxia', 1),
(8, TRUE, 'Balance Issues', 1),
(9, TRUE, 'Blindness', 1),
(10, TRUE, 'Brain Hemorrhage', 1),
(11, TRUE, 'Cataract', 1),
(12, TRUE, 'Cavernoma', 1),
(13, TRUE, 'Constipation', 1),
(14, TRUE, 'Cramps', 1),
(15, TRUE, 'Death', 1),
(16, TRUE, 'Dehydration', 1),
(17, TRUE, 'Diabetes - Insipidus', 1),
(18, TRUE, 'Diet - Aversion', 1),
(19, TRUE, 'Diet - Modification', 1),
(20, TRUE, 'Endocrine Issues', 1),
(21, TRUE, 'Epilepsy', 1),
(22, TRUE, 'Facial Paralysis', 1),
(23, TRUE, 'Falls', 1),
(24, TRUE, 'Fatigue', 1),
(25, TRUE, 'Femoral Torsion', 1),
(26, TRUE, 'Fine Motor Skills Issues', 1),
(27, TRUE, 'Foot Drop', 1),
(28, TRUE, 'Growth', 1),
(29, TRUE, 'Hair Loss', 1),
(30, TRUE, 'Hearing Loss', 1),
(31, TRUE, 'Hormonal Issues', 1),
(32, TRUE, 'Hypoxic Events', 1),
(33, TRUE, 'Infections', 1),
(34, TRUE, 'Kidney Issues', 1),
(35, TRUE, 'Leg Growth Issues', 1),
(36, TRUE, 'Long Term Memory Loss', 1),
(37, TRUE, 'Loss of Appetite', 1),
(38, TRUE, 'Low Energy', 1),
(39, TRUE, 'Medulloblastoma', 1),
(40, TRUE, 'Meningitis', 1),
(41, TRUE, 'Migraines', 1),
(42, TRUE, 'Migraines - Stomach', 1),
(43, TRUE, 'Moyamoya', 1),
(44, TRUE, 'Mucositis', 1),
(45, TRUE, 'Muscle Atrophy', 1),
(46, TRUE, 'Neck Issues', 1),
(47, TRUE, 'Neuralgia', 1),
(48, TRUE, 'Neuropathy', 1),
(49, TRUE, 'Neuropathy - Peripheral', 1),
(50, TRUE, 'Osteopenia', 1),
(51, TRUE, 'Osteoporosis', 1),
(52, TRUE, 'Paralysis', 1),
(53, TRUE, 'Paralysis - Partial', 1),
(54, TRUE, 'Physical Disability', 1),
(55, TRUE, 'Pituitary - Hypopituitarism', 1),
(56, TRUE, 'Pituitary Issues', 1),
(57, TRUE, 'Pnemonia', 1),
(58, TRUE, 'Peripheral Neuroepithelioma - PNET (Askin Tumor)', 1),
(59, TRUE, 'Posteria Fossa', 1),
(60, TRUE, 'Remission', 1),
(61, TRUE, 'RSV', 1),
(62, TRUE, 'Scoliosis', 1),
(63, TRUE, 'Seizures', 1),
(64, TRUE, 'Sensitivity - Skin', 1),
(65, TRUE, 'Shingles', 1),
(66, TRUE, 'Short Stature', 1),
(67, TRUE, 'Short Term Memory Loss', 1),
(68, TRUE, 'Sinus Complications', 1),
(69, TRUE, 'Sleep Issues', 1),
(70, TRUE, 'Slow Growth', 1),
(71, TRUE, 'Somnolence Syndrome', 1),
(72, TRUE, 'Speech - Dysarthria', 1),
(73, TRUE, 'Speech Issues ', 1),
(74, TRUE, 'Strabismus', 1),
(75, TRUE, 'Stroke', 1),
(76, TRUE, 'Swallowing - Difficulty', 1),
(77, TRUE, 'Swelling', 1),
(78, TRUE, 'Thyroid Issues', 1),
(79, TRUE, 'Tremors - Hand', 1),
(80, TRUE, 'UOP', 1),
(81, TRUE, 'Vision - Double', 1),
(82, TRUE, 'Vision - Nystagmus', 1),
(83, TRUE, 'Vision Loss - Full', 1),
(84, TRUE, 'Vision Loss - Partial', 1),
(85, TRUE, 'Vomiting/Nausea', 1),
(86, TRUE, 'Voval Fold Paralysis', 1),
(87, TRUE, 'Walking Issues', 1),
(88, TRUE, 'Weakness - General', 1),
(89, TRUE, 'Weakness/Hemiparesis - Left or Right Side', 1),
(90, TRUE, 'Weight Gain', 1),
(91, TRUE, 'Weight Loss', 1),
(92, TRUE, 'Accutane', 2),
(93, TRUE, 'Amputation', 2),
(94, TRUE, 'Anesthesia', 2),
(95, TRUE, 'Chemotherapy', 2),
(96, TRUE, 'Chemotherapy - Cisplatin', 2),
(97, TRUE, 'Chemotherapy - Oral', 2),
(98, TRUE, 'Chemotherapy - Vincistine', 2),
(99, TRUE, 'Cortisol Treatment', 2),
(100, TRUE, 'Dental Work', 2),
(101, TRUE, 'Feeding Tube', 2),
(102, TRUE, 'Gastrostomy Tube / Feeding Tube (G Tube)', 2),
(103, TRUE, 'Growth Hormone', 2),
(104, TRUE, 'Hearing Aid', 2),
(105, TRUE, 'Hemiplegia', 2),
(106, TRUE, 'Immunity Issues', 2),
(107, TRUE, 'IV', 2),
(108, TRUE, 'Leg Braces', 2),
(109, TRUE, 'MRI', 2),
(110, TRUE, 'Neck Brace', 2),
(111, TRUE, 'Nerve Graft', 2),
(112, TRUE, 'Occupational Therapy', 2),
(113, TRUE, 'Proton Beam Radiation', 2),
(114, TRUE, 'Radiation', 2),
(115, TRUE, 'Radiation - Gamma Knife', 2),
(116, TRUE, 'Radiation - Proton', 2),
(117, TRUE, 'Shunt', 2),
(118, TRUE, 'Shunt - VP', 2),
(119, TRUE, 'Stem Cells', 2),
(120, TRUE, 'Surgery', 2),
(121, TRUE, 'Tracheostomy', 2),
(122, TRUE, 'Trial Study', 2);
INSERT INTO DIAGNOSIS(DIAGNOSIS_ID, DESCRIPTION) VALUES
(1, 'Anaplastic Astrocytoma'),
(2, 'Anaplastic Ependymoma'),
(3, 'Anaplastic Medulloblastoma / Large Cell'),
(4, 'Astrocytoma'),
(5, 'Astrocytoma / Low Grade'),
(6, 'ATRT (Atypical Teratoid/Rhabdoid Tumor)'),
(7, 'Benign Meningioma (Meningioangiomotosis)'),
(8, 'Brain Stem Glioma'),
(9, 'Brainstem Tumor'),
(10, 'Cerebellar Astrocytoma'),
(11, 'CNS Germ Cell Tumor (Nongerminomatous)'),
(12, 'Cranialpharingioma / Malignant'),
(13, 'Craniopharyngioma / Benign'),
(14, 'Desmoplastic Infantile Ganglioma'),
(15, 'Diffuse Brain Stem Glioma'),
(16, 'Diffuse Pontine Brainstem Glioma'),
(17, 'Ependymoblastoma'),
(18, 'Ependymoma'),
(19, 'Extraventricular Neurocytoma / Grade 2'),
(20, 'Ganglioglioma'),
(21, 'Glioblastoma'),
(22, 'Glioma / Low Grade'),
(23, 'Glioma / Malignant'),
(24, 'Gliomatosis Cerebri'),
(25, 'Glioneuro Astrocytoma'),
(26, 'Glioneurocytoma'),
(27, 'Hamartoma / Benign'),
(28, 'Hypothalamic Astrocytoma'),
(29, 'Hypothalamic Optic Chiasm Pilocytic Astrocytoma'),
(30, 'Juvenile Pilocytic Astrocytoma (JPA)'),
(31, 'Juvenile Pilocytic Astrocytoma (JPA) / Brainstem'),
(32, 'Juvenile Pilocytic Astrocytoma (JPA) / Cerebellum)'),
(33, 'Juvenile Pilocytic Astrocytoma (JPA) / Right Thalamus'),
(34, 'Juvenile Pilocytic Astrocytoma (JPA) /Midbrain'),
(35, 'Medullablastoma'),
(36, 'Meningioangioendolethialmetosis'),
(37, 'Mixed Germ Cell'),
(38, 'Neurofibromatosis (NFI)'),
(39, 'Oligodendroglioma'),
(40, 'Optic Chiasm Glioma'),
(41, 'Optic Glioma / Non NF / Non Neurofibromatosis'),
(42, 'Osteosarcoma'),
(43, 'Pilocytic Astrocytoma'),
(44, 'Pilocytic Astrocytoma / Brain Stem'),
(45, 'Pilocytic Astrocytoma / Cerebellum'),
(46, 'Pilocytic Astrocytoma w/ dissemination'),
(47, 'Pituitary Adenoma'),
(48, 'Pituitary Tumor'),
(49, 'PNET (Primitive Neuroectodermal Tumor)'),
(50, 'PNET / Brainstem'),
(51, 'Pontine Glioma'),
(52, 'Tectal Plate Glioma'),
(53, 'Tectalglioma'),
(54, 'Third Ventricle Glioma (Astrocytoma)');




--Dummy Data
insert into users(id, admin, active) values('work@pls', false, false);
insert into users(id, admin, active) values('work@gmail.com', true, true);
insert into users(id, admin, active) values('bafz86@mst.edu', false, false);
insert into users(id, admin, active) values('fabirk93@gmail.com',true, true);
insert into users(id, admin, active) values('kylemiller457@gmail.com',false, true);
insert into users(id, admin, active) values('thanlone1995@gmail.com',true, true);


--Contact #1
insert into contact(contact_Id, first_Name, last_Name, mentor, mentee, do_Not_Contact,
primary_Phone_Number, primary_Phone_Number_Visible_To_Match, secondary_Phone_Number, secondary_Phone_Number_Visible_To_Match,
city, state, primary_Email, primary_Email_Visible_To_Match, secondary_Email, secondary_Email_Visible_To_Match, contact_Note, admin_Note)
values (1, 'John', 'Smith', TRUE, FALSE, FALSE,
'8009999999', TRUE, NULL, FALSE,
'St. Louis', 'MO', 'work@pls', TRUE, NULL, FALSE, 'I can be reached by email or SMS.', 'Great feedback from prior matches.');

--Contact #2
insert into contact(contact_Id, first_Name, last_Name, mentor, mentee, do_Not_Contact,
primary_Phone_Number, primary_Phone_Number_Visible_To_Match, secondary_Phone_Number, secondary_Phone_Number_Visible_To_Match,
city, state, primary_Email, primary_Email_Visible_To_Match, secondary_Email, secondary_Email_Visible_To_Match, contact_Note, admin_Note)
values (2, 'Janis', 'Joplin', FALSE, TRUE, FALSE,
'8675309', TRUE, NULL, FALSE,
'St. Louis', 'MO', 'piece@heart', TRUE, NULL, FALSE, 'I can be reached by email or SMS.', 'Great feedback from prior matches.');

--Contact #3
insert into contact(contact_Id, first_Name, last_Name, mentor, mentee, do_Not_Contact,
primary_Phone_Number, primary_Phone_Number_Visible_To_Match, secondary_Phone_Number, secondary_Phone_Number_Visible_To_Match,
city, state, primary_Email, primary_Email_Visible_To_Match, secondary_Email, secondary_Email_Visible_To_Match, contact_Note, admin_Note)
values (3, 'Tom', 'Bombadil', FALSE, TRUE, FALSE,
'111222333', TRUE, NULL, FALSE,
'St. Louis', 'MO', 'shire@forest', TRUE, NULL, FALSE, 'I can be reached by butterfly', 'Great feedback from prior matches.');

--Mentor_Mentee
insert into mentor_mentee(mentor, mentee, time_matched) values (1,3, 1490405554);

insert into child(child_id, bereaved, date_of_birth, date_of_death, first, last, contact_id)
values (1, FALSE, 946706400000, NULL, 'Tyler', 'Smith', 1);

insert into child_diagnosis(child_id, diagnosis_id, age_of_diagnosis)
values (1, 45, 2);

insert into child_subcategory(child_id, subcategory_id)
values (1, 7),
(1, 53),
(1, 54),
(1, 73),
(1, 74),
(1, 76),
(1, 79),
(1, 89),
(1, 109),
(1, 126),
(1, 140),
(1, 142),
(1, 143),
(1, 145),
(1, 173),
(1, 174),
(1, 193);

insert into category_note(child_id, category_id, note)
values (1, 1, 'Loss of balance and facial paralysis. Smile surgery where tongue nerve was used for smile.'),
(1, 2, 'Surgery was only treatment. 2 resection surgeries.');


/* new added dummy data into alert table */
insert into alerts_update(date_time, message) values(1490459787000, 'A generic message');
insert into alerts_update (date_time, message) values (1488040587000, 'Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.');
insert into alerts_update (date_time, message) values (1456418187000, 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.');
