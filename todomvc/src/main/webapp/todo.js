//초기데이터 (나중에는 서버에서 받아올 부분)

let basicDatas = [];

function getTodos(){
    const xhr = new XMLHttpRequest();
    xhr.open("get","http://localhost:8080/todomvc/api/todos");          
    xhr.onreadystatechange = function(){
       if(xhr.readyState === 4 ){
           if(xhr.status === 200){
               // json 문자열을 json 객체로 변환시킨다.
               var todos = JSON.parse(this.responseText);
               console.log(todos);
               for(let i = 0; i < todos.length; i++){
                   todoItemAdd(todos[i]);
               }
            }
        }
   }
   xhr.send();          
}

function updateTodo(id){
    let updateTodo = {"id":id};
    let xhr = new XMLHttpRequest();
    xhr.open('PATCH','http://localhost:8080/todomvc/api/todos');
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.send(JSON.stringify(updateTodo));
}

function deleteTodo(id){
    let delTodo = {"id": id};
    let xhr = new XMLHttpRequest();
    xhr.open('DELETE','http://localhost:8080/todomvc/api/todos');
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.send(JSON.stringify(delTodo));
}

function postTodo(todo){
    let xhr = new XMLHttpRequest();
    xhr.open('post','http://localhost:8080/todomvc/api/todos');
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.onload = function(){
        // 글쓰기를 할 경우 ajax의 결과를 json 오브젝트로 변환하여 추가한다.
        todoItemAdd(JSON.parse(xhr.responseText));   
    };
    xhr.send(JSON.stringify({"todo":todo}));
}

getTodos();

let todoUl = document.querySelector("#todo-item-list");

todoUl.addEventListener('click',function(event){
    let eventTarget = event.target; 
    if(event.target.tagName === 'LI' || event.target.tagName === 'SPAN'){
        if(event.target.tagName ==='LI'){
            eventTarget =eventTarget.querySelector('.todo-text');
        }
       
        let liObj = eventTarget.parentElement;

        updateTodo(liObj.getAttribute("id"));
        eventTarget.classList.toggle('checked');
    }
});

 const inputbtn = document.querySelector('.add-button');
//  const myinput = document.querySelector('#myInput');
 

inputbtn.addEventListener('click', function(){
    inputValue = document.querySelector('#myInput').value;
    if(inputValue === ''){
        alert("할 일을 입력해 주세요^^ "); 
        return;
    }
    document.querySelector('#myInput').value = '';
    postTodo(inputValue);
});

function todoItemAdd(todoObj){   
    console.log(todoObj);
    const li = document.createElement('li');
    li.className = "todo-item";
    const textSpan = document.createElement('SPAN');
    textSpan.className = "todo-text" ;
    
    const todotxt = document.createTextNode(todoObj.todo);
    textSpan.appendChild(todotxt);
    if(todoObj.done == true){
        // 완료된 작업일 경우 css를 이용하여 줄을 긋는다.
        textSpan.classList.toggle('checked');
    }
    li.appendChild(textSpan);
    li.setAttribute("id", todoObj.id);
    document.getElementById('todo-item-list').appendChild(li);
    
    const removeSpan = document.createElement("SPAN");
    const removetxt = document.createTextNode("\u00D7");
    removeSpan.className = "remove";

    removeSpan.appendChild(removetxt);
    li.appendChild(removeSpan);

    // 동적으로 x버튼을 클릭했을 때 처리해야할 이벤트를 추가한다.
    removeSpan.addEventListener('click',function(){
        let liObj = this.parentElement;
        console.log(liObj);
        deleteTodo(liObj.getAttribute("id"));
        liObj.remove();
        return false; // return false를 하지 않으면 수정이 되면서 update를 호출한다.이미 삭제된 것을 수정하려고 하니 오류가 발생한다. https://programmingsummaries.tistory.com/313
    });
};
