package team.free.freeway.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.free.freeway.init.dto.value.StationFacilities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "facilities")
@Entity
public class Facilities {

    @Id
    private String id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @Column(name = "elevator")
    private Boolean elevator;

    @Column(name = "wheelchair_lift")
    private Boolean wheelchairLift;

    @Column(name = "disabled_toilet")
    private Boolean disabledToilet;

    @Column(name = "transit_parking_lot")
    private Boolean transitParkingLot;

    @Column(name = "unmanned_civil_application_issuing_machine")
    private Boolean unmannedCivilApplicationIssuingMachine;

    @Column(name = "currency_exchange_kiosk")
    private Boolean currencyExchangeKiosk;

    @Column(name = "train_ticket_office")
    private Boolean trainTicketOffice;

    @Column(name = "feeding_room")
    private Boolean feedingRoom;

    @Builder
    public Facilities(String id, Station station, Boolean elevator, Boolean wheelchairLift, Boolean disabledToilet,
                      Boolean transitParkingLot, Boolean unmannedCivilApplicationIssuingMachine,
                      Boolean currencyExchangeKiosk, Boolean trainTicketOffice, Boolean feedingRoom) {
        this.id = id;
        this.station = station;
        this.elevator = elevator;
        this.wheelchairLift = wheelchairLift;
        this.disabledToilet = disabledToilet;
        this.transitParkingLot = transitParkingLot;
        this.unmannedCivilApplicationIssuingMachine = unmannedCivilApplicationIssuingMachine;
        this.currencyExchangeKiosk = currencyExchangeKiosk;
        this.trainTicketOffice = trainTicketOffice;
        this.feedingRoom = feedingRoom;
    }

    public static Facilities defaultObject(Station station) {
        return Facilities.builder()
                .station(station)
                .build();
    }

    public void updateInfo(StationFacilities stationFacilities) {
        elevator = stationFacilities.hasElevator();
        wheelchairLift = stationFacilities.hasWheelchairLift();
        transitParkingLot = stationFacilities.hasTransitParkingLot();
        unmannedCivilApplicationIssuingMachine = stationFacilities.hasUnmannedCivilApplicationIssuingMachine();
        currencyExchangeKiosk = stationFacilities.hasCurrencyExchangeKiosk();
        trainTicketOffice = stationFacilities.hasTrainTicketOffice();
        feedingRoom = stationFacilities.hasFeedingRoom();
    }

    public void updateDisabledToilet(Boolean disabledToilet) {
        this.disabledToilet = disabledToilet;
    }
}
