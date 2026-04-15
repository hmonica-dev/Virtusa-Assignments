def match_skills(resume_skills, job_skills):
    matched = set(resume_skills).intersection(set(job_skills))
    missing = set(job_skills) - set(resume_skills)

    match_score = (len(matched) / len(job_skills)) * 100

    return match_score, matched, missing