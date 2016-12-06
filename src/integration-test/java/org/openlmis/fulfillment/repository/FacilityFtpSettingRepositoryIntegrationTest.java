package org.openlmis.fulfillment.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.openlmis.fulfillment.domain.FacilityFtpSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Random;
import java.util.UUID;

public class FacilityFtpSettingRepositoryIntegrationTest
    extends BaseCrudRepositoryIntegrationTest<FacilityFtpSetting> {

  @Autowired
  private FacilityFtpSettingRepository facilityFtpSettingRepository;

  @Override
  protected CrudRepository<FacilityFtpSetting, UUID> getRepository() {
    return facilityFtpSettingRepository;
  }

  @Override
  protected FacilityFtpSetting generateInstance() {
    FacilityFtpSetting setting = new FacilityFtpSetting();
    setting.setProtocol("ftp");
    setting.setFacilityId(UUID.randomUUID());
    setting.setServerHost(RandomStringUtils.random(10));
    setting.setServerPort(new Random().nextInt(9000) + 1000);
    setting.setRemoteDirectory(RandomStringUtils.random(10));
    setting.setLocalDirectory(RandomStringUtils.random(10));
    setting.setUsername(RandomStringUtils.random(10));
    setting.setPassword(RandomStringUtils.random(10));
    setting.setPassiveMode(true);

    return setting;
  }

  @Test
  public void shouldFindSettingByFacilityId() {
    UUID facilityId = UUID.randomUUID();

    FacilityFtpSetting setting = generateInstance();
    setting.setFacilityId(facilityId);

    facilityFtpSettingRepository.save(setting);

    FacilityFtpSetting found = facilityFtpSettingRepository.findFirstByFacilityId(facilityId);

    assertThat(found.getId(), is(setting.getId()));
  }

}