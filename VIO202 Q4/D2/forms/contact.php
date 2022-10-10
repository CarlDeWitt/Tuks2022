<?php
  // $receiving_email_address = 'carldewitt04@gmail.com';
  //   $to = $receiving_email_address;
  //   $from_name = $_POST['name'];
  //   $from_email = $_POST['email'];
  //   $subject = $_POST['subject'];

  //   mail($to, $subject, $message, "From:" . $from_email);
    $to      = 'nobody@example.com';
    $subject = 'the subject';
    $message = 'hello';
    $headers = 'From: webmaster@example.com'       . "\r\n" .
                 'Reply-To: webmaster@example.com' . "\r\n" .
                 'X-Mailer: PHP/' . phpversion();

    mail($to, $subject, $message, $headers);
?>
