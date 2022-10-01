const allUsers = [];
const allBuyerTypes = [];

$(document).ready(function() {
    resolveAuthorizationButtons();

    $.ajax({
        async: true,
        type: 'GET',
        url: 'api/authorization/logged-user',
        dataType: 'json',
        success: function(retrievedLoggedUser) {
            if (retrievedLoggedUser['role'] != 'ADMINISTRATOR') {
                alert('Ova funkcionalnost namenjena je samo administratorima!');

                window.location.href = 'index.html';

                return;
            }

            fillOutUsersTable();
        },
        error: function() {
            alert('Niste prijavljeni!');

            window.location.href = 'login.html';
        }
    });
});

function resolveAuthorizationButtons() {
    $('#registrationAsABuyerButton').click(function() {
        window.location.href = 'registration.html';
    });
    
    $('#logoutButton').click(function() {
        $.ajax({
            async: true,
            type: 'POST',
            url: 'api/authorization/logout',
            data: '',
            success: function() {
                alert('Korisnik je uspešno odjavljen!');
                
                window.location.href = 'index.html';
            },
            error: function(message) {
                alert(message.responseText);
            }
        });
    });
}

function fillOutUsersTable() {
    $.ajax({
        async: true,
        type: 'GET',
        url: 'api/users',
        dataType: 'json',
        success: function(retrievedUsers) {
            for (let user of retrievedUsers) {
                allUsers.push(user);
                
                let newTableRow = $('<tr></tr>');
                
                let newTableHeader = $('<th></th>');
                newTableHeader.attr('scope', 'row');
                newTableHeader.text(user['id']);
                newTableRow.append(newTableHeader);
                
                newTableData = resolveUser(user);
                newTableRow.append(newTableData);
                
                $('#usersTable > tbody').append(newTableRow);
            }
        },
        error: function(message) {
            alert(message.responseText);
        }
    });
}

function resolveUser(user) {
    let userTableData = $('<td></td>');
    userTableData.addClass('userTableData');

    userTableData.append(createUserCard(user));
    
    return userTableData;
}

function createUserCard(user) {
    let userCard = $('<div></div>');
    userCard.addClass('card text-center text-white bg-dark border-light');
    
    userCard.append(fillOutUserCardBody(user));
    
    return userCard;
}

function fillOutUserCardBody(user) {
    let userCardBody = $('<div></div>');
    userCardBody.addClass('card-body');
    
    let userCardTitle = $('<h5></h5>');
    userCardTitle.addClass('card-title');
    userCardTitle.text(user['username']);
    
    let userCardSubtitle = $('<h6></h6>');
    userCardSubtitle.addClass('card-subtitle mb-2');
    userCardSubtitle.text(user['firstName'] + ' ' + user['lastName']);
    
    let userCardText = $('<p></p>');
    userCardText.addClass('card-text');
    userCardText.text(printUserRole(user));
    
    userCardBody.append(userCardTitle);
    userCardBody.append(userCardSubtitle);
    userCardBody.append(userCardText);
    
    return userCardBody;
}

function printUserRole(user) {
    let userRoleInSerbian = '';
    switch (user['role']) {
        case 'ADMINISTRATOR':
            userRoleInSerbian = 'Administrator';
            break;
        case 'VENUE_MANAGER':
            userRoleInSerbian = 'Menadžer objekta';
            break;
        case 'TRAINER':
            userRoleInSerbian = 'Trener';
            break;
        case 'BUYER':
            userRoleInSerbian = 'Kupac, tip: ' + resolveBuyerType(user['buyerTypeId']);
            break;
    }

    return userRoleInSerbian;
}

function resolveBuyerType(buyerTypeId) {
    let buyerTypeName = '';

    for (let bType of allBuyerTypes) {
        if (bType['id'] == buyerTypeId) {
            buyerTypeName = bType['name'];

            return buyerTypeName;
        }
    }

    $.ajax({
        async: false,
        type: 'GET',
        url: 'api/buyer-types/' + buyerTypeId,
        dataType: 'json',
        success: function(retrievedBuyerType) {
            allBuyerTypes.push(retrievedBuyerType);
            buyerTypeName = retrievedBuyerType['name'];
        },
        error: function(message) {
            alert(message.responseText);
        }
    });

    return buyerTypeName;
}
