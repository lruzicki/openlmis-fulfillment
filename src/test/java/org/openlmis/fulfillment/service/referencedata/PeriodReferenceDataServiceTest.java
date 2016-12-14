package org.openlmis.fulfillment.service.referencedata;

public class PeriodReferenceDataServiceTest
    extends BaseReferenceDataServiceTest<ProcessingPeriodDto> {

  @Override
  BaseReferenceDataService<ProcessingPeriodDto> getService() {
    return new PeriodReferenceDataService();
  }

  @Override
  ProcessingPeriodDto generateInstance() {
    return new ProcessingPeriodDto();
  }
}