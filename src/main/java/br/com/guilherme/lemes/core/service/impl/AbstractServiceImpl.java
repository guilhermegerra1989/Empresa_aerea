package br.com.guilherme.lemes.core.service.impl;

import br.com.guilherme.lemes.core.domain.bean.*;
import br.com.guilherme.lemes.core.domain.enumeration.MessageType;
import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;
import br.com.guilherme.lemes.core.repository.GenericRepository;
import br.com.guilherme.lemes.core.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;


@Transactional
public abstract class AbstractServiceImpl<E extends Serializable, R extends GenericRepository<E>> implements Service<E> {
    private R repository;


    protected AbstractServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public PaginatedListDto<E> getAllPaginated(Integer page, Integer amount) {
        return repository.findAllPaginated(page, amount);
    }

    public E getById(Long id) {
        return repository.findById(id);
    }

    public E save(E entity) {
        repository.save(entity);

        return entity;
    }

    public E update(E entity) {
        repository.update(entity);

        return entity;
    }

    public void delete(Long id) {
        E entity = getById(id);
        repository.delete(entity);
    }

    @Override
    public List<E> getAllById(List<Long> equipmentIds) {
        return getRepository().findAllById(equipmentIds);
    }

    public R getRepository() {
        return repository;
    }







 /*   private ObjectEvent createLaneEvent(E entity) {
        Lane lane = (Lane) entity;
        LaneEventMessage laneEventMessage = new LaneEventMessage();
        BeanUtils.copyProperties(entity, laneEventMessage, new String[] { "operationPlace", "componentInfo", "configRules" });

        if (lane.getComponentInfo() != null)
            laneEventMessage.setComponentInfoSerialNumber(lane.getComponentInfo().getSerialNumber());

        if (lane.getOperationPlace() != null)
            laneEventMessage.setOperationPlaceSerialNumber(lane.getOperationPlace().getSerialNumber());

        return laneEventMessage;
    }

    private ObjectEvent createOperationPlaceEvent(E entity) {
        OperationPlace operationPlace = (OperationPlace) entity;
        OperationPlaceEventMessage operationPlaceEventMessage = new OperationPlaceEventMessage();
        BeanUtils.copyProperties(entity, operationPlaceEventMessage, new String[] { "equipment", "lanes" });

        for (Lane lane : operationPlace.getLanes()) {
            operationPlaceEventMessage.getLaneSerialNumbers().add(lane.getSerialNumber());
        }

        return operationPlaceEventMessage;
    }

    private ObjectEvent createEquipmentEvent(E entity) {
        EquipmentEventMessage equipmentEventMessage = new EquipmentEventMessage();
        BeanUtils.copyProperties(entity, equipmentEventMessage, new String[] { "equipmentConfiguration", "cameras", "sensors", "components", "operationPlaces" });
        return equipmentEventMessage;
    }

    private ObjectEvent createComponentInfoEvent(E entity) {
        ComponentInfo componentInfo = (ComponentInfo) entity;
        ComponentInfoEventMessage componentInfoEventMessage = new ComponentInfoEventMessage();
        BeanUtils.copyProperties(entity, componentInfoEventMessage, new String[] { "equipment", "cameraInfos", "sensorInfos" });

        for (CameraInfo cameraInfo : componentInfo.getCameraInfos()) {
            componentInfoEventMessage.getCameraInfosSerialNumber().add(cameraInfo.getSerialNumber());
        }

        if (componentInfo.getSensorInfo() != null)
            componentInfoEventMessage.setSensorInfoSerialNumber(componentInfo.getSensorInfo().getSerialNumber());

        if (componentInfo.getLane() != null)
            componentInfoEventMessage.setLaneSerialNumber(componentInfo.getLane().getSerialNumber());

        return componentInfoEventMessage;
    }

    private ObjectEvent createSensorInfoEvent(E entity) {
        SensorInfoEventMessage sensorInfoEventMessage = new SensorInfoEventMessage();
        BeanUtils.copyProperties(entity, sensorInfoEventMessage, new String[] { "componentInfo", "equipment" });
        return sensorInfoEventMessage;
    }

    private ObjectEvent createCameraInfoEvent(E entity) {
        CameraInfoEventMessage cameraInfoEventMessage = new CameraInfoEventMessage();
        BeanUtils.copyProperties(entity, cameraInfoEventMessage, new String[] { "componentInfos", "equipment" });
        return cameraInfoEventMessage;
    }
*/

}