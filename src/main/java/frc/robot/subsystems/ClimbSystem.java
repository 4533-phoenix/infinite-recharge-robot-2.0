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
}
