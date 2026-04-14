import spacy

nlp = spacy.load("en_core_web_sm")

SKILLS_DB = [
    "python", "java", "c++", "machine learning",
    "deep learning", "sql", "html", "css",
    "javascript", "data analysis", "nlp"
]

def extract_skills(text):
    text = text.lower()
    extracted_skills = []

    for skill in SKILLS_DB:
        if skill in text:
            extracted_skills.append(skill)

    return sorted(list(set(extracted_skills)))