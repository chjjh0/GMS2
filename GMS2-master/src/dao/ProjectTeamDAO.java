package dao;

import java.util.List;
import domain.*;

public interface ProjectTeamDAO {
	public void insertTeam(ProjectTeamBean team);
	public List<ProjectTeamBean> selectProjectTeamList();
	public List<ProjectTeamBean> selectProjectTeamByName(String name);
	public ProjectTeamBean selectProjectTeamByID(String id);
	public int countProjectTeam();
	public void updateProjectTeam(ProjectTeamBean team);
	public void deleteProjectTeam(ProjectTeamBean team);
}
