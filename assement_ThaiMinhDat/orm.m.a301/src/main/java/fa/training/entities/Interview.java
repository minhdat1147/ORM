package fa.training.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "INTERVIEW",schema = "training")
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "interview_id", unique = true)
	private int interviewId;

	@Column(name="time",columnDefinition = "varchar(255)", nullable = false)
	private String time;
	@Column(name="date",columnDefinition = "date", nullable = false)
	private LocalDate date;
	
	private String interviewer;
	
	@Column(columnDefinition = "varchar(2000)")
	private String comments;
	
	@Column(name = "interview_result")
	private String interviewResult;
	
	@Column(columnDefinition = "varchar(1000)")
	private String remark;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidate_id",referencedColumnName = "candidate_id",nullable = false)
	private Candidate interviewCandidateId;

	/**
	 * @return the interviewId
	 */
	public int getInterviewId() {
		return interviewId;
	}

	/**
	 * @param interviewId the interviewId to set
	 */
	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
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
	 * @return the interviewer
	 */
	public String getInterviewer() {
		return interviewer;
	}

	/**
	 * @param interviewer the interviewer to set
	 */
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the interviewResult
	 */
	public String getInterviewResult() {
		return interviewResult;
	}

	/**
	 * @param interviewResult the interviewResult to set
	 */
	public void setInterviewResult(String interviewResult) {
		this.interviewResult = interviewResult;
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
	 * @return the interviewCandidateId
	 */
	public Candidate getInterviewCandidateId() {
		return interviewCandidateId;
	}

	/**
	 * @param interviewCandidateId the interviewCandidateId to set
	 */
	public void setInterviewCandidateId(Candidate interviewCandidateId) {
		this.interviewCandidateId = interviewCandidateId;
	}

	public Interview(String time, LocalDate date, String interviewer, String comments, String interviewResult,
			String remark, Candidate interviewCandidateId) {
		super();
		this.time = time;
		this.date = date;
		this.interviewer = interviewer;
		this.comments = comments;
		this.interviewResult = interviewResult;
		this.remark = remark;
		this.interviewCandidateId = interviewCandidateId;
	}

	public Interview() {
		super();
	}

	@Override
	public String toString() {
		return "Interview [interviewId=" + interviewId + ", time=" + time + ", date=" + date + ", interviewer="
				+ interviewer + ", comments=" + comments + ", interviewResult=" + interviewResult + ", remark=" + remark
				+ ", interviewCandidateId=" + interviewCandidateId + "]";
	}

	

}
