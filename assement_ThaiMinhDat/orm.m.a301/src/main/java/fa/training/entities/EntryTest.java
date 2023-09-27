package fa.training.entities;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name = "EntryTest",schema = "training")
public class EntryTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id", unique = true)
	private int testId;

	@Column(name="time",columnDefinition = "varchar(255)", nullable = false)
	private String time;
	@Column(name="date",columnDefinition = "date", nullable = false)
	private LocalDate date;

	@Column(name = "language_valuator")
	private String languageValuator;

	@Range(min = 0, max = 10, message = "Skill level 0 -> 10 only")
	@Column(name = "language_result", columnDefinition = "decimal(4,2)")
	private double languageResult;

	@Column(name = "technical_valuator")
	private String technicalValuator;

	@Range(min = 0, max = 10, message = "Skill level 0 -> 10 only")
	@Column(name = "technical_result", columnDefinition = "decimal(4,2)")
	private double technicalResult;

	@Pattern(regexp = "^((?i)pass|(?i)fail)$", message = "must match pass or fail")
	private String result;

	@Column(columnDefinition = "varchar(1000)")
	private String remark;

	@Column(name = "entry_test_skill")
	private String entryTestSkill;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id", nullable = false)
	private Candidate entryTestCandidateId;

	/**
	 * @return the testId
	 */
	public int getTestId() {
		return testId;
	}

	/**
	 * @param testId the testId to set
	 */
	public void setTestId(int testId) {
		this.testId = testId;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the languageValuator
	 */
	public String getLanguageValuator() {
		return languageValuator;
	}

	/**
	 * @param languageValuator the languageValuator to set
	 */
	public void setLanguageValuator(String languageValuator) {
		this.languageValuator = languageValuator;
	}

	/**
	 * @return the languageResult
	 */
	public double getLanguageResult() {
		return languageResult;
	}

	/**
	 * @param languageResult the languageResult to set
	 */
	public void setLanguageResult(double languageResult) {
		this.languageResult = languageResult;
	}

	/**
	 * @return the technicalValuator
	 */
	public String getTechnicalValuator() {
		return technicalValuator;
	}

	/**
	 * @param technicalValuator the technicalValuator to set
	 */
	public void setTechnicalValuator(String technicalValuator) {
		this.technicalValuator = technicalValuator;
	}

	/**
	 * @return the technicalResult
	 */
	public double getTechnicalResult() {
		return technicalResult;
	}

	/**
	 * @param technicalResult the technicalResult to set
	 */
	public void setTechnicalResult(double technicalResult) {
		this.technicalResult = technicalResult;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
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
	 * @return the entryTestSkill
	 */
	public String getEntryTestSkill() {
		return entryTestSkill;
	}

	/**
	 * @param entryTestSkill the entryTestSkill to set
	 */
	public void setEntryTestSkill(String entryTestSkill) {
		this.entryTestSkill = entryTestSkill;
	}

	/**
	 * @return the entryTestCandidateId
	 */
	public Candidate getEntryTestCandidateId() {
		return entryTestCandidateId;
	}

	/**
	 * @param entryTestCandidateId the entryTestCandidateId to set
	 */
	public void setEntryTestCandidateId(Candidate entryTestCandidateId) {
		this.entryTestCandidateId = entryTestCandidateId;
	}

	public EntryTest(String time, LocalDate date, String languageValuator,
			@Range(min = 0, max = 10, message = "Skill level 0 -> 10 only") double languageResult,
			String technicalValuator,
			@Range(min = 0, max = 10, message = "Skill level 0 -> 10 only") double technicalResult,
			@Pattern(regexp = "^((?i)pass|(?i)fail)$", message = "must match pass or fail") String result,
			String remark, String entryTestSkill, Candidate entryTestCandidateId) {
		super();
		this.time = time;
		this.date = date;
		this.languageValuator = languageValuator;
		this.languageResult = languageResult;
		this.technicalValuator = technicalValuator;
		this.technicalResult = technicalResult;
		this.result = result;
		this.remark = remark;
		this.entryTestSkill = entryTestSkill;
		this.entryTestCandidateId = entryTestCandidateId;
	}

	public EntryTest() {
		super();
	}

	@Override
	public String toString() {
		return "EntryTest [testId=" + testId + ", time=" + time + ", date=" + date + ", languageValuator="
				+ languageValuator + ", languageResult=" + languageResult + ", technicalValuator=" + technicalValuator
				+ ", technicalResult=" + technicalResult + ", result=" + result + ", remark=" + remark
				+ ", entryTestSkill=" + entryTestSkill + ", entryTestCandidateId=" + entryTestCandidateId + "]";
	}

	
}
