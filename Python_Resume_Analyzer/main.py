from resume_parser import extract_resume_text
from skill_extractor import extract_skills
from job_matcher import match_skills
from utils import read_job_description
resume_text = extract_resume_text("sample_data/resume.pdf")
resume_skills = extract_skills(resume_text)
job_text = read_job_description("sample_data/job.txt")
job_skills = extract_skills(job_text)
score, matched, missing = match_skills(resume_skills, job_skills)

print("\n--- Resume Analysis ---")
print("Resume Skills:", resume_skills if resume_skills else "No skills found")
print("Job Skills:", job_skills)

print(f"\nMatch Score: {score:.2f}%")
print("Matched Skills:", matched if matched else "None")
print("Missing Skills:", missing if missing else "None")


print("\nSuggestions:")
if missing:
    for skill in missing:
        print(f"- Learn {skill}")
else:
    print("Great! You match all required skills.")