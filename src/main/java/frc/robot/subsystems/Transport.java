package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.spikes2212.dashboard.RootNamespace;
import com.spikes2212.util.smartmotorcontrollers.TalonFXWrapper;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Transport extends SubsystemBase {

    private final TalonFXWrapper talon;
    private static Transport instance;
    private RootNamespace namespace;

    private Transport(TalonFXWrapper talon){
        this.talon=talon;
        configureDashboard();
    }

    public static Transport getInstance() {
        if (instance == null) {
            instance = new Transport(
                    new TalonFXWrapper(RobotMap.CAN.SHOOTER_TALON_ID));
        }
        return instance;
    }

    public void spin(double speed){
        talon.set(speed);
    }

    public void stop(){
        talon.stopMotor();
    }

    public void configureDashboard() {
        namespace = new RootNamespace("transport");
        namespace.putNumber("talon speed", talon::getVelocity);
    }
}
