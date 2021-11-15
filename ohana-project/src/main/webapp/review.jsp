<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Révision</title>
    <style type="text/css">
        table { border: 0; }
        table td { padding: 5px; }
    </style>
</head>
<body>
<div align="center">
    <h1>Veuillez vérifier votre commande avant de payer</h1>
    <form action="execute_payment" method="post">
        <table>
            <tr>
                <td colspan="2"><b>Détails :</b></td>
                <td>
                    <input type="hidden" name="paymentId" value="${param.paymentId}" />
                    <input type="hidden" name="PayerID" value="${param.PayerID}" />
                </td>
            </tr>
            <tr>
                <td>Description:</td>
                <td>${transaction.description}</td>
            </tr>
            <tr>
                <td>Total HT:</td>
                <td>${transaction.amount.details.subtotal} EUR</td>
            </tr>
            <tr>
                <td>Shipping :</td>
                <td>${transaction.amount.details.shipping} EUR</td>
            </tr>
            <tr>
                <td>Taxe :</td>
                <td>${transaction.amount.details.tax} EUR</td>
            </tr>
            <tr>
                <td>Total :</td>
                <td>${transaction.amount.total} EUR</td>
            </tr>
            <tr><td><br/></td></tr>
            <tr>
                <td colspan="2"><b>Information de l'acheteur :</b></td>
            </tr>
            <tr>
                <td>Prénom :</td>
                <td>${payer.firstName}</td>
            </tr>
            <tr>
                <td>Nom :</td>
                <td>${payer.lastName}</td>
            </tr>
            <tr>
                <td>Email :</td>
                <td>${payer.email}</td>
            </tr>
            <tr><td><br/></td></tr>
            <tr>
                <td colspan="2"><b>Adresse de livraison :</b></td>
            </tr>
            <tr>
                <td>Nom du vendeur :</td>
                <td>${shippingAddress.recipientName}</td>
            </tr>
            <tr>
                <td>Ligne 1:</td>
                <td>${shippingAddress.line1}</td>
            </tr>
            <tr>
                <td>Ville :</td>
                <td>${shippingAddress.city}</td>
            </tr>
            <tr>
                <td>Région :</td>
                <td>${shippingAddress.state}</td>
            </tr>
            <tr>
                <td>Code Pays :</td>
                <td>${shippingAddress.countryCode}</td>
            </tr>
            <tr>
                <td>Code Postal :</td>
                <td>${shippingAddress.postalCode}</td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Payer maintenant" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
