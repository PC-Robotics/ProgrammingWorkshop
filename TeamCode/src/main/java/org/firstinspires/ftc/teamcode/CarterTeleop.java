package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name = "Carter Teleop")
public class CarterTeleop extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor motor;
        motor = hardwareMap.get(DcMotor.class, "motor");
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setZeroPowerBehavior(BRAKE);

        waitForStart();


        while(opModeIsActive()){
            if(gamepad1.square){
                motor.setPower(1);  //Spins the Motor Forward
            }
            else if(gamepad1.circle){
                motor.setPower(-1);  //Spins the Motor Backwards
            }
            else{
                motor.setPower(0);  //Stops the motor
            }

            double triggerValue = gamepad1.right_trigger;


            double joystickValue = gamepad1.left_stick_x;

            motor.setPower(triggerValue);
            if(joystickValue > 0.05)
                motor.setPower(joystickValue);

            telemetry.addData("Stick value  ::  ", joystickValue);
            telemetry.addData("Trigger Value  ::  ", triggerValue);
            telemetry.addData("Motor power  ::  ", motor.getPower());

            telemetry.update();




        }
    }

    public static double deadzone(double input){
        if(input < 0.05){
            return input;
        }
        else{
            return 0;
        }
    }
}
