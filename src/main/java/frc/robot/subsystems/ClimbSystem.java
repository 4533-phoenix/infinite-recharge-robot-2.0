package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class ClimbSystem extends SubsystemBase {
    private WPI_TalonSRX hookMotor;
    private WPI_TalonSRX climbMotor;

    private static final double HOOK_PERCENT_OUTPUT = 0.9;
    private static final double HOOK_DOWN_PERCENT_OUTPUT = 0.4;
    private static final double CLIMB_PERCENT_OUTPUT = 0.5;

    public ClimbSystem() {
        hookMotor = new WPI_TalonSRX(4);
        climbMotor = new WPI_TalonSRX(5);

        hookMotor.setNeutralMode(NeutralMode.Brake);
        climbMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void resetPosition() {
        hookMotor.setSelectedSensorPosition(0);
        climbMotor.setSelectedSensorPosition(0);
    }

    public void stop() {
        hookMotor.set(ControlMode.PercentOutput, 0);
        climbMotor.set(ControlMode.PercentOutput, 0);
    }

    public void hookUp() {
        hookMotor.set(ControlMode.PercentOutput, HOOK_PERCENT_OUTPUT);
    }

    public void hookDown() {
        hookMotor.set(ControlMode.PercentOutput, HOOK_DOWN_PERCENT_OUTPUT);
    }

    public void climb() {
        climbMotor.set(ControlMode.PercentOutput, CLIMB_PERCENT_OUTPUT);
    }

    @Override
    public void periodic() {
    }
}
