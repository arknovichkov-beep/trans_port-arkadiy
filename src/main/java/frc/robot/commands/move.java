package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Transport;

import java.util.function.Supplier;

public class move extends Command {

    private final Supplier<Double> speedSupplier;
    private final Transport transport;

    public move(Transport transport, Supplier<Double> speedSupplier){
        this.speedSupplier = speedSupplier;
        this.transport = transport;
    }

    public void execute() {transport.spin(speedSupplier.get( ));}
    public boolean isFinished() {return false;}
    public void end(boolean interupted) {transport.stop();}

}
 