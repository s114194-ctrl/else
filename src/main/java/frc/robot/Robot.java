package frc.robot;
 
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

 

public class Robot extends TimedRobot {
 
  private static final int MOTOR_ID = 12;  
  private static final int MODE = 2;      

 
  private final SparkMax motor = new SparkMax(MOTOR_ID, MotorType.kBrushless);
  private final XboxController controller = new XboxController(1);

  public Robot() {
    SparkMaxConfig config = new SparkMaxConfig();
    config.idleMode(IdleMode.kBrake);  
    config.smartCurrentLimit(40);         
    config.openLoopRampRate(0.5);  
    motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}
 
  @Override
  public void teleopInit() {
    motor.set(0); 
  }
 
  @Override
  public void teleopPeriodic() {
    if (MODE == 1) {
      mode1();
    } else  {
      mode2();
    } 
    //else {
      //mode3();
    //} 
  }

//mode1
  private void mode1() {
    if (controller.getAButton()) {
      motor.set(0.3);  
    } else {
      motor.set(0);  
    }
  }
 
//mode2
  private void mode2() {
    if (controller.getAButton()) {
      motor.set(0.3);   
    } else if (controller.getBButton()) {
      motor.set(-0.3);  
    } else {
      motor.set(0);  
    }  
  }

 
  @Override
  public void disabledInit() {
    motor.set(0);
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
 
}