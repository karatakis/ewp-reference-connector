
package eu.erasmuswithoutpaper.course.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = LearningOpportunityInstance.findAll, query = "select l from LearningOpportunityInstance l")
public class LearningOpportunityInstance implements Serializable {
    
    private static final String PREFIX = "eu.erasmuswithoutpaper.course.entity.LearningOpportunityInstance.";
    public static final String findAll = PREFIX + "all";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;

    private String institutionId;
    
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "learning_opp_spec", referencedColumnName = "ID")
    private LearningOpportunitySpecification learningOppSpec;
    
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "academic_term", referencedColumnName = "ID")
    private AcademicTerm academicTerm;
    private String credits;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public LearningOpportunitySpecification getLearningOppSpec() {
        return learningOppSpec;
    }

    public void setLearningOppSpec(LearningOpportunitySpecification learningOppSpec) {
        this.learningOppSpec = learningOppSpec;
    }

    public AcademicTerm getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(AcademicTerm academicTerm) {
        this.academicTerm = academicTerm;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LearningOpportunityInstance other = (LearningOpportunityInstance) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
