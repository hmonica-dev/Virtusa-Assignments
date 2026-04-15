# Resume Analyzer & Job Matcher

## About the Project
This project is a simple Python-based tool that analyzes a resume and compares it with a given job description. It calculates how well the resume matches the job requirements and also highlights the missing skills.

The main idea behind this project is to help freshers understand what skills they need to improve in their resumes.

---

## Features
- Reads resume from PDF file  
- Extracts text using Python  
- Compares resume with job description  
- Calculates match percentage  
- Shows matched and missing skills  

---

## Technologies Used
- Python
- spaCy (for basic NLP)
- pdfminer (for reading PDF) 

---

## Project Structure

Python_Resume_Analyzer/
│── main.py
│── resume_parser.py
│── skill_extractor.py
│── job_matcher.py
│── utils.py
│── sample_data/
│ ├── resume.pdf
│ └── job.txt


---

## How to Run
1. Install required libraries:

pip install spacy pdfminer.six
python -m spacy download en_core_web_sm


2. Run the program:

python main.py


---

## Sample Output
### Example 1:
![Output 1](screenshot1.png)

### Example 2:
![Output 2](screenshot2.png)


---

## Conclusion
A smart assistant that helps users improve resumes and increases chances of getting shortlisted.

## Author
Monica H
