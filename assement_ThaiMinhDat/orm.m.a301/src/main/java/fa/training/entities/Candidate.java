package fa.training.entities;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CANDIDATE",schema = "training")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private int candidateId;

	@NotBlank(message = "{candidate.fieldnotnull}")
	@Column(name = "full_name", nullable = false)
	private String fullName;

	@NotNull(message = "{candidate.fieldnotnull}")
	@Column(name = "date_of_birth",nullable = false)
	private LocalDate dateOfBirth;

	@Range(min = 0,max = 1, message = "Gender 0(female) or 1(male) only")
	private int gender;

	@NotNull(message = "{candidate.fieldnotnull}")
	@Column(name = "graduation_year")
	private LocalDate graduationYear;

	@NotBlank(message = "{candidate.fieldnotnull}")
	@Column(unique = true)
	private String phone;

	@NotBlank(message = "{candidate.fieldnotnull}")
	@Column(unique = true)
	private String email;

	private String skill;

	@Column(name = "foreign_language")
	private String foreignLanguage;

	@Range(min = 0, max = 7, message = "Skill level 1 -> 7 only.")
	private int level;

	private String cv;

	@Column(name = "allowcation_status")
	private int allowcationStatus;

	@Column(columnDefinition = "varchar(1000)")
	private String remark;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "interviewCandidateId",fetch = FetchType.LAZY)
	private Set<Interview> setInterview = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "entryTestCandidateId",fetch = FetchType.LAZY)
	private Set<EntryTest> setEntryTest = new HashSet<>();

	/**
	 * @return the candidateId
	 */
	public int getCandidateId() {
		return candidateId;
	}

	/**
	 * @param candidateId the candidateId to set
	 */
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * @return the graduationYear
	 */
	public LocalDate getGraduationYear() {
		return graduationYear;
	}

	/**
	 * @param graduationYear the graduationYear to set
	 */
	public void setGraduationYear(LocalDate graduationYear) {
		this.graduationYear = graduationYear;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the skill
	 */
	public String getSkill() {
		return skill;
	}

	/**
	 * @param skill the skill to set
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}

	/**
	 * @return the foreignLanguage
	 */
	public String getForeignLanguage() {
		return foreignLanguage;
	}

	/**
	 * @param foreignLanguage the foreignLanguage to set
	 */
	public void setForeignLanguage(String foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the cv
	 */
	public String getCv() {
		return cv;
	}

	/**
	 * @param cv the cv to set
	 */
	public void setCv(String cv) {
		this.cv = cv;
	}

	/**
	 * @return the allowcationStatus
	 */
	public int getAllowcationStatus() {
		return allowcationStatus;
	}

	/**
	 * @param allowcationStatus the allowcationStatus to set
	 */
	public void setAllowcationStatus(int allowcationStatus) {
		this.allowcationStatus = allowcationStatus;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the interview
	 */
	public Set<Interview> getInterview() {
		return getInterview();
	}

	/**
	 * @param interview the interview to set
	 */
	public void setInterview(Set<Interview> setInterview) {
		this.setInterview = setInterview;
	}

	/**
	 * @return the entryTest
	 */
	public Set<EntryTest> getEntryTest() {
		return getEntryTest();
	}

	/**
	 * @param entryTest the entryTest to set
	 */
	public void setEntryTest(Set<EntryTest> getEntryTest) {
		this.setEntryTest = getEntryTest;
	}

	

	public Candidate(@NotBlank(message = "{candidate.fieldnotnull}") String fullName,
			@NotNull(message = "{candidate.fieldnotnull}") LocalDate dateOfBirth,
			@Range(min = 0, max = 1, message = "Gender 0(female) or 1(male) only") int gender,
			@NotNull(message = "{candidate.fieldnotnull}") LocalDate graduationYear,
			@NotBlank(message = "{candidate.fieldnotnull}") String phone,
			@NotBlank(message = "{candidate.fieldnotnull}") String email, String skill, String foreignLanguage,
			@Range(min = 0, max = 7, message = "Skill level 1 -> 7 only.") int level, String cv, int allowcationStatus,
			String remark) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.graduationYear = graduationYear;
		this.phone = phone;
		this.email = email;
		this.skill = skill;
		this.foreignLanguage = foreignLanguage;
		this.level = level;
		this.cv = cv;
		this.allowcationStatus = allowcationStatus;
		this.remark = remark;
	}

	public Candidate() {
		super();
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", graduationYear=" + graduationYear + ", phone=" + phone + ", email=" + email
				+ ", skill=" + skill + ", foreignLanguage=" + foreignLanguage + ", level=" + level + ", cv=" + cv
				+ ", allowcationStatus=" + allowcationStatus + ", remark=" + remark + "]";
	}
	
	
}
