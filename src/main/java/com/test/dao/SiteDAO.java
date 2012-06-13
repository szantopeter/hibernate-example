package com.test.dao;

import com.test.domain.Site;

public interface SiteDAO {

	public abstract Site readSiteBySiteId(int siteId);

	public abstract Site readSiteBySiteCode(String siteCode);

	public abstract void updateSite(Site site);

}