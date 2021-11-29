package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.SlotConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;

public class DriveSystem extends SubsystemBase {
    private WPI_TalonSRX leftMaster;
    private WPI_TalonSRX rightMaster;
    private WPI_TalonSRX leftSlave;
    private WPI_TalonSRX rightSlave;

    private AHRS navX;

    private static final double MAX_OUTPUT = 400;
    private static final double TURBO_OUTPUT = 475;
    private static final double PEAK_OUTPUT = 1.0;
    private boolean turbo = false;

    public DriveSystem() {
        leftMaster = new WPI_TalonSRX(0);
        rightMaster = new WPI_TalonSRX(1);
        leftSlave = new WPI_TalonSRX(2);
        rightSlave = new WPI_TalonSRX(3);

        leftSlave.follow(leftMaster, FollowerType.AuxOutput1);
        rightSlave.follow(rightMaster, FollowerType.AuxOutput1);

        
    }
}
