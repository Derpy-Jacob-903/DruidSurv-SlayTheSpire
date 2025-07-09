package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.Prized;

import static druidsurv.ModFile.makeID;

public class SuperMonkey extends AbstractEasyCard {
    public final static String ID = makeID("SuperMonkey");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SuperMonkey() {
        super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY, "SuperMonkey_CardArt");
        baseDamage = 11;
        baseMagicNumber = magicNumber = 6;
        baseSecondMagic = secondMagic = cost*2;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);

        this.setCardBack(cardSubType.MONKEY);
    }

    public void atTurnStart() {
        int temp = AbstractDungeon.getCurrRoom().monsters.monsters.size();
        //(3-X)*2
        //secondMagic = (4-costForTurn)*2;
        //for (int j = 0; j < temp; j++) {
            //AbstractMonster a = AbstractDungeon.getCurrRoom().monsters.monsters.get(j);
            //if (a.currentHealth < baseDamage*3 && j == 1) {
                //costForTurn = 5;
            //} else if (a.currentHealth < baseDamage*3 && j < 3 && costForTurn < 4) {
                //costForTurn = 4;
            //}
        //}
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        //secondMagic = (4-costForTurn)*2;
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new Prized(p, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    @Override
    public void upp() {
        upgradeDamage(5);
    }
}