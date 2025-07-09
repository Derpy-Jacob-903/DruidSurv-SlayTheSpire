package druidsurv.cards.bloons;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.bloons.BasicBloonPower;
import druidsurv.relics.CueBall;

import static druidsurv.ModFile.makeID;

public class Zomg extends AbstractEasyCard {
    public final static String ID = makeID("ZOMG");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Zomg() {
        super(ID, 4, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY, "ZOMG_CardArt");
        baseDamage = 200;
        baseBlock = 10;
        baseMagicNumber = magicNumber = 1;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.LARGE);
        this.exhaust = true;
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if(AbstractDungeon.player.hasRelic(CueBall.ID)){ damage *= 0.75; addToBot((AbstractGameAction)new GainEnergyAction(this.magicNumber));};
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new BasicBloonPower(m, 5, damage, this.name), 1, true, AbstractGameAction.AttackEffect.NONE));
        bloonBlck();
    }

    @Override
    public void upp()
    {
        upgradeDamage(50);
        upgradeBlock(10);
    }
}