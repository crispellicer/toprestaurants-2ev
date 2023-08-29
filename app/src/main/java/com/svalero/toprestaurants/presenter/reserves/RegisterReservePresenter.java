package com.svalero.toprestaurants.presenter.reserves;

import com.svalero.toprestaurants.contract.reserves.RegisterReserveContract;
import com.svalero.toprestaurants.domain.Reserve;
import com.svalero.toprestaurants.model.reserves.RegisterReserveModel;
import com.svalero.toprestaurants.view.reserves.RegisterReserveView;

public class RegisterReservePresenter implements RegisterReserveContract.Presenter {

    private RegisterReserveModel model;
    private RegisterReserveView view;

    public RegisterReservePresenter(RegisterReserveView view) {
        model = new RegisterReserveModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void registerReserve(Reserve reserve) {
        boolean done = model.registerReserve(reserve);
        if (done) {
            view.showMessage("Reserva registrada correctamente");
            view.resetForm();
        } else {
            view.showError("Se ha producido un error al registrar la reserva. Comprueba que los datos son correctos");
        }
    }
}
